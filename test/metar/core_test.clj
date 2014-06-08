(ns metar.core-test
  (:require [clojure.test :refer :all]
            [metar.test-data :as data]
            [metar.core :as core]))

(deftest summary 
  (doseq [metar-data data/metars]
    (testing (:raw metar-data)
      (let [result (core/summary (:raw metar-data))]
        (is (map? result))
        (is (= (:airport result) (:airport metar-data)))
        (is (= (:day result) (:day metar-data)))
        (is (= (:hour result) (:hour metar-data)))
        (is (= (:minute result) (:minute metar-data)))
        (is (= (:wind-direction result) (:wind-direction metar-data)))
        (is (= (:wind-speed-knots result) (:wind-speed-knots metar-data)))
        (is (= (:wind-gust-knots result) (:wind-gust-knots metar-data)))
        (is (= (:visibility result) (:visibility metar-data)))
        (is (= (:sky-conditions result) (:sky-conditions metar-data)))
        (is (= (:temperature result) (:temperature metar-data)))
        (is (= (:dewpoint result) (:dewpoint metar-data)))
        (is (= (:altimiter result) (:altimiter metar-data)))))))
