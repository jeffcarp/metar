(ns metar.test-data)

(def metars [
  {
    :raw "KSFO 042256Z 30015G22KT 10SM FEW008 19/11 A2985 RMK AO2 SLP107 T01940111"
    :airport "KSFO"
    :day "04"
    :hour "22"
    :minute "56"
    :wind-direction "300"
    :wind-speed-knots "15"
    :wind-gust-knots "22"
    :visibility "10"
    :cloud-cover "FEW"
    :cloud-altitude "800"
  }
  {
    :raw "METAR KOAK 060653Z 33007KT 10SM FEW006 13/11 A2984 RMK AO2 SLP103 T01280106"
    :airport "KOAK"
    :day "06"
    :hour "06"
    :minute "53"
    :wind-direction "330"
    :wind-speed-knots "07"
    :wind-gust-knots nil
    :visibility "10"
    :cloud-cover "FEW"
    :cloud-altitude "600"
  }
  {
    :raw "METAR KJFK 060751Z 32011KT 10SM BKN080 17/08 A2981 RMK AO2 SLP094 T01720083 $"
    :airport "KJFK"
    :day "06"
    :hour "07"
    :minute "51"
    :wind-direction "320"
    :wind-speed-knots "11"
    :wind-gust-knots nil
    :visibility "10"
    :cloud-cover "BKN"
    :cloud-altitude "8000"
  }
  ])
