(ns metar.core-test
  (:require [clojure.test :refer :all]
            [metar.core :refer :all]))

(def sample-data [
	"KSFO 042256Z 30015G22KT 10SM FEW008 19/11 A2985 RMK AO2 SLP107 T01940111"
 ])

(deftest test-parse
  (testing "parses date"
    (is (= (metar.core/parse "KSFO 042256Z 30015G22KT 10SM FEW008 19/11 A2985 RMK AO2 SLP107 T01940111") "METAR"))))
