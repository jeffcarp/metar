(ns metar.core
  "Can pass all these functions (except summary) a full or partial METAR string."
  (:require [clojure.string :as string :only [split replace]]))

(defn parts
  "Returns a vector of strings from a METAR string."
  [metar-str]
  (string/split metar-str #" "))

(defn find-parts
  "Finds METAR parts based on a regex applied to each part."
  [regex metar-str]
  (let [metar-parts (parts metar-str)
        matches? (partial re-matches regex)]
    (filter matches? metar-parts)))

(defn find-part
  "When you're only looking for one part."
  [regex metar-str]
  (let [matching-parts (find-parts regex metar-str)]
    (or (first matching-parts) "")))

; Experimental helper
(defn re-find-last
  [regex search]
  (last (re-find regex search)))

(defn airport
  "Returns a string with the ICAO identifier."
  [metar-str]
  (find-part #"[A-Z][A-Z0-9]{3}" metar-str))

(defn day
  "Extracts the day of the month from a METAR string."
  [metar-str]
  (let [datetime-str (find-part #"^\d{6}Z$" metar-str)]
    (subs datetime-str 0 2)))

(defn hour 
  "Extracts the hour (24h) from a METAR string."
  [metar-str]
  (let [datetime-str (find-part #"^\d{6}Z$" metar-str)]
    (subs datetime-str 2 4)))

(defn minute 
  "Extracts the minute from a METAR string."
  [metar-str]
  (let [datetime-str (find-part #"^\d{6}Z$" metar-str)]
    (subs datetime-str 4 6)))

(defn wind-direction
  [metar-str]
  (let [wind-str (find-part #"(\d{3}|VRB)[0-9A-Z]+KT$" metar-str)]
    (if (empty? wind-str)
      nil
      (subs wind-str 0 3))))

(defn wind-speed-knots
  [metar-str]
  (let [wind-str (find-part #"(\d{3}|VRB)[0-9A-Z]+KT$" metar-str)]
    (if (empty? wind-str)
      nil
      (subs wind-str 3 5))))

(defn wind-gust-knots
  [metar-str]
  (let [wind-str (find-part #"\d{3}[0-9A-Z]+KT$" metar-str)]
    (last (re-find #"G(\d+)KT" wind-str))))

(defn wind-variable-from-to
  [metar-str]
  (let [wind-str (find-part #"\d{3}V\d{3}" metar-str)
        from (re-find-last #"(\d{3})V\d{3}" wind-str)
        to   (re-find-last #"\d{3}V(\d{3})" wind-str)]
    (if (and from to)
      [from to]
      nil)))

(defn visibility-miles
  "Returns a string with the visibility."
  [metar-str]
  (let [visibility-str (find-part #"[\d\/]+SM" metar-str)]
    (string/replace visibility-str #"SM" "")))

(defn temperature 
  "Returns a string with the temperature."
  [metar-str]
  (let [tempdew-str (find-part #"\d+\/M?\d+" metar-str)]
    (last (re-find #"^(M?\d+)\/" tempdew-str))))

(defn dewpoint 
  "Returns a string with the dewpoint."
  [metar-str]
  (let [tempdew-str (find-part #"\d+\/M?\d+" metar-str)]
    (last (re-find #"\/(M?\d+)$" tempdew-str))))

(defn altimiter 
  "Returns a string of the altimiter setting in inHg."
  [metar-str]
  (let [altimiter-str (find-part #"A\d{4}" metar-str)
        main-num (subs altimiter-str 1 3)
        decimal (subs altimiter-str 3)]
    (str main-num "." decimal)))

(defn sky-conditions
  "Returns a vector of maps for the sky conditions."
  [metar-str]
  (let [condition-parts (find-parts #"(SKC|CLR|NSC|FEW|SCT|BKN|OVC)\d{0,3}" metar-str)
        condition-maps (map (fn [condstr] { :kind (subs condstr 0 3) :altitude (subs condstr 3) }) condition-parts)]
    (if (empty? condition-maps)
      nil
      condition-maps)))

(defn phenomena
  "Returns a vector of strings describing current weather phenomena."
  [metar-str]
  (find-parts #"TS|DR|SH|MI|FZ|BC|BL|PR|RA|DZ|SN|GR|GS|PL|SG|IC|UP|BR|BLSN|FG" metar-str))

(defn runway-visual-range
  "Returns a vector of maps, one per runway, specifying visual range."
  [metar-str]
  (let [range-parts (find-parts #"R\d+\/\d+FT" metar-str)
        feet (fn [range-str] (re-find-last #"R\d+\/(\d+)FT" range-str))
        runway (fn [range-str] (re-find-last #"R(\d+)\/\d+FT" range-str))
        ranger (fn [range-str] { :feet (feet range-str) :runway (runway range-str) })]
    (if (empty? range-parts)
      nil
      (map ranger range-parts))))

(defn summary
  "Returns a map of all data from a METAR string."
  [metar-str]
  {
    :airport          (airport metar-str)
    :day              (day metar-str)
    :hour             (hour metar-str)
    :minute           (minute metar-str)
    :wind-direction   (wind-direction metar-str)
    :wind-speed-knots (wind-speed-knots metar-str)
    :wind-gust-knots  (wind-gust-knots metar-str)
    :wind-variable-from-to (wind-variable-from-to metar-str)
    :visibility-miles (visibility-miles metar-str)
    :runway-visual-range (runway-visual-range metar-str)
    :sky-conditions   (sky-conditions metar-str)
    :phenomena        (phenomena metar-str)
    :temperature      (temperature metar-str)
    :dewpoint         (dewpoint metar-str)
    :altimiter        (altimiter metar-str)
  })
