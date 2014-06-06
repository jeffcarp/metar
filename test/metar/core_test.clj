(ns metar.core-test
  (:require [clojure.test :refer :all]
            [metar.test-data :as data]
            [metar.core :as core]))

(deftest valid
  (doseq [metar-data data/metars]
    (testing (str "returns true: " (:raw metar-data))
      (is (true? (core/valid (:raw metar-data))))))

  (testing "returns false for an invalid METAR"
    (let [result (core/valid "stuff")]
      (is (false? result)))))


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
        (is (= (:cloud-cover result) (:cloud-cover metar-data)))
        (is (= (:cloud-altitude result) (:cloud-altitude metar-data)))
        (is (= (:temperature result) (:temperature metar-data)))
        (is (= (:dewpoint result) (:dewpoint metar-data)))
        (is (= (:altimiter result) (:altimiter metar-data)))
))))
