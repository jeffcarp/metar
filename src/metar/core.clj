(ns metar.core
  (:require [clojure.string :as string :only [split]]))

(defn valid
  "Validates a METAR."
  [metar-str]
  (let [parts (string/split metar-str #" ")]
    (and
      (< 4 (count parts)))))

(defn part
  "Returns the requested string part of the METAR."
  [metar-str ident]
  (let [parts (string/split metar-str #" ")]
    (case ident
      "airport"  (nth parts 0)
      "datetime" (nth parts 1)
      "wind"     (nth parts 2))))

(defn day
  "Extracts the day of the month from the datetime."
  [datetime-str]
  (subs datetime-str 0 2))

(defn wind-direction
  [wind-str]
  (subs wind-str 0 3))

(defn wind-speed 
  [wind-str]
  (last (re-find #"(\d+)[G|KT]" (subs wind-str 3))))

(defn wind-gust
  [wind-str]
  (last (re-find #"G(\d+)KT" (subs wind-str 3))))

(defn parse
  "Takes a string, retuns METAR weather data."
  [metar-str]
  (let [section (partial part metar-str)]
    {
      :airport (section "airport") 
      :day (day (section "datetime"))
      :wind-direction (wind-direction (section "wind"))
      :wind-speed-knots (wind-speed (section "wind"))
      :wind-gust-knots (wind-gust (section "wind"))
    }))

