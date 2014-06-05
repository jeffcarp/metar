(ns metar.core-test
  (:require [clojure.test :refer :all]
            [metar.test-data :as data]
            [metar.core :as core]))

(deftest valid
  (testing "parses airport"
    (let [result (core/valid (first data/metars))]
    (is (= true result))
)))

(deftest parse
  (testing "parses airport"
    (let [result (core/parse (first data/metars))]
    (is (map? result))
    (is (= (:airport result) "KSFO"))
    (is (= (:wind-direction result) "300"))
    (is (= (:wind-speed-knots result) "15"))
    (is (= (:wind-gust-knots result) "22")))))

