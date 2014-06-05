(ns metar.core-test
  (:require [clojure.test :refer :all]
            [metar.test-data :as data]
            [metar.core :as core]))

(deftest valid
  (testing "returns true for a valid METAR"
    (let [result (core/valid (first data/metars))]
      (is (true? result))))

  (testing "returns false for an invalid METAR"
    (let [result (core/valid "stuff")]
      (is (false? result)))))

(deftest parse
  (testing "parses airport"
    (let [result (core/parse (first data/metars))]
    (is (map? result))
    (is (= (:airport result) "KSFO"))
    (is (= (:day result) "04"))
    (is (= (:wind-direction result) "300"))
    (is (= (:wind-speed-knots result) "15"))
    (is (= (:wind-gust-knots result) "22")))))

(deftest part
  (let [section (partial part (first data/metars))]
    (testing "parses airport"
      (is (= "KSFO" (section "airport"))))
    (testing "parses datetime"
      (is (= "042256Z" (section "datetime"))))
    (testing "parses wind"
      (is (= "30015G22KT" (section "wind"))))))

(deftest day
  (testing "handles regular input"
    (is (= "04" (core/day "042256Z")))))

