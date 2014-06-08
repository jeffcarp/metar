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
    :sky-conditions [
      { :kind "FEW" :altitude "008" }
    ]
    :temperature "19"
    :dewpoint "11"
    :altimiter "29.85"
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
    :sky-conditions [
      { :kind "FEW" :altitude "006" }
    ]
    :temperature "13"
    :dewpoint "11"
    :altimiter "29.84"
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
    :sky-conditions [
      { :kind "BKN" :altitude "080" }
    ]
    :temperature "17"
    :dewpoint "08"
    :altimiter "29.81"
    :remarks [
      "A02"
      "SLP094"
      "T01720083"
      "$"
    ]
  }
  {
    :raw "METAR KORD 072051Z 12012KT 10SM FEW075 BKN200 OVC250 27/09 A2988 RMK AO2 SLP114 T02670094 55014"
    :airport "KORD"
    :day "07"
    :hour "20"
    :minute "51"
    :wind-direction "120"
    :wind-speed-knots "12"
    :wind-gust-knots nil
    :visibility "10"
    :sky-conditions [
      { :kind "FEW" :altitude "075" }
      { :kind "BKN" :altitude "200" }
      { :kind "OVC" :altitude "250" }
    ]
    :temperature "27"
    :dewpoint "09"
    :altimiter "29.88"
    :remarks [
      "A02"
      "SLP114"
      "T02670094"
      "55014"
    ]
  }
  ])
