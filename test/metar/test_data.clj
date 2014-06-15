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
    :visibility-miles "10"
    :phenomena []
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
    :visibility-miles "10"
    :phenomena []
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
    :visibility-miles "10"
    :phenomena []
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
    :visibility-miles "10"
    :phenomena []
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
  {
    :raw "METAR KBNA 281250Z 33018KT 290V360 1/2SM R31/2700FT SN BLSN FG VV008 00/M03 A2991 RMK RAE42SNB42"
    :airport "KBNA"
    :day "28"
    :hour "12"
    :minute "50"
    :wind-direction "330"
    :wind-speed-knots "18"
    :wind-gust-knots nil
    :wind-variable-from-to ["290" "360"]
    :visibility-miles "1/2"
    :runway-visual-range [
      { :runway "31" :feet "2700" }
    ]
    :vertical-visibility "008"
    :phenomena ["SN" "BLSN" "FG"]
    :sky-conditions []
    :temperature "00"
    :dewpoint "M03"
    :altimiter "29.91"
    :remarks [
      "RAE42"
      "SNB42"
    ]
  }
  {
    :raw "METAR KSFO 041453Z AUTO VRB02KT 3SM BR CLR 15/12 A3012 RMK AO2"
    :report-type "METAR"
    :production "AUTO"
    :airport "KSFO"
    :day "04"
    :hour "14"
    :minute "53"
    :wind-direction "VRB"
    :wind-speed-knots "02"
    :visibility-miles "3"
    :phenomena ["BR"]
    :sky-conditions [
      { :kind "CLR" :altitude "" }
    ]
    :temperature "15"
    :dewpoint "12"
    :altimiter "30.12"
    :remarks [
      "AO2"
    ]
  }
  {
    :raw "ORER 150600Z 02004KT CAVOK 34/06 Q1008"
    :report-type nil
    :production nil
    :airport "ORER"
    :day "15"
    :hour "06"
    :minute "00"
    :wind-direction "020"
    :wind-speed-knots "04"
    :visibility-miles "CAVOK"
    :phenomena []
    :sky-conditions []
    :temperature "34"
    :dewpoint "06"
    :altimiter "10.08"
  }
])
