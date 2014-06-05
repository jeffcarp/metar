(ns metar.core-test
  (:require [clojure.test :refer :all]
            [metar.core :refer :all]))

(deftest test-parse
  (testing "parses airport"
    (let [result (metar.core/parse "KSFO 042256Z 30015G22KT 10SM FEW008 19/11 A2985 RMK AO2 SLP107 T01940111")]
    (is (map? result))
    (is (= (:airport result) "KSFO"))
    (is (= (:wind-direction result) "300"))
    (is (= (:wind-speed-knots result) "15"))
    (is (= (:wind-gust-knots result) "22")))))
