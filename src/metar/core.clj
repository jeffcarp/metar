(ns metar.core
  (:require [clojure.string :as string :only [split]]))

(defn valid
  "Validates a METAR."
  [metar-str]
  (let [parts (string/split metar-str #" ")]
    (println "count parts" (count parts) parts)
    (boolean
      (and
        (< 4 (count parts))))))

(defn parse
  "Takes a string, retuns METAR weather data."
  [metar-str]
  (let [parts (string/split metar-str #" ")
        airport (first parts)
        datetime (nth parts 1)
        day (subs datetime 0 2)
        wind (nth parts 2)
        direction (subs wind 0 3)
        speed (subs wind 3)
        wind-speed (last (re-find #"(\d+)[G|KT]" speed)) 
        wind-gust (last (re-find #"G(\d+)KT" speed))]
    {
      :airport airport 
      :day day 
      :wind-direction direction
      :wind-speed-knots wind-speed
      :wind-gust-knots wind-gust
    }))
