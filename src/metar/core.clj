(ns metar.core
  (:require [clojure.string :as string :only [split replace]]))

(defn parts
  "Returns a vector of strings from a METAR string."
  [metar-str]
  (let [parts (string/split metar-str #" ")]
    (if (or (= "METAR" (first parts)) (= "SPECI" (first parts)))
      (drop 1 parts)
      parts)))

(defn airport
  "Returns the ICAO identifier of a METAR string."
  [metar-str]
  (first (parts metar-str)))

(defn day
  "Extracts the day of the month from a METAR string."
  [metar-str]
  (subs (second (parts metar-str)) 0 2))

(defn hour 
  "Extracts the hour (24) from a METAR string."
  [metar-str]
  (subs (second (parts metar-str)) 2 4))

(defn minute 
  "Extracts the minute from a METAR string."
  [metar-str]
  (subs (second (parts metar-str)) 4 6))

(defn wind-direction
  [metar-str]
  (subs (nth (parts metar-str) 2) 0 3))

(defn wind-speed-knots
  [metar-str]
  (last (re-find #"(\d+)[G|KT]" (subs (nth (parts metar-str) 2) 3))))

(defn wind-gust-knots
  [metar-str]
  (last (re-find #"G(\d+)KT" (subs (nth (parts metar-str) 2) 3))))

(defn visibility 
  [metar-str]
  (string/replace (nth (parts metar-str) 3) #"\D" "")) 

(defn cloud-cover 
  [metar-str]
  (subs (nth (parts metar-str) 4) 0 3))

(defn cloud-altitude
  [metar-str]
  (let [cloud-str (nth (parts metar-str) 4)
        alt-str (subs cloud-str 4)
        full-alt-str (str alt-str "00")]
    (string/replace full-alt-str #"^0+" "")))

(defn temperature 
  [metar-str]
  (subs (nth (parts metar-str) 5) 0 2))

(defn dewpoint 
  [metar-str]
  (subs (nth (parts metar-str) 5) 3 5))

(defn altimiter 
  [metar-str]
  (let [alt-str (nth (parts metar-str) 6)
        main-num (subs alt-str 1 3)
        decimal (subs alt-str 3)]
    (str main-num "." decimal)))

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
    :visibility       (visibility metar-str)
    :cloud-cover      (cloud-cover metar-str)
    :cloud-altitude   (cloud-altitude metar-str)
    :temperature      (temperature metar-str)
    :dewpoint         (dewpoint metar-str)
    :altimiter        (altimiter metar-str)
  })
