# metar

[![Build Status](https://travis-ci.org/jeffcarp/metar.svg?branch=master)](https://travis-ci.org/jeffcarp/metar)

A WMO-306 I.i.A compliant METAR weather report parser for Clojure.

> DISCLAIMER: NOT FEATURE COMPLETE, DO NOT USE YET

METARS are frequently used for estimating runway conditions at a given airport.

## Installation

Add this to `:dependencies` in your `project.clj`

```clojure
[metar "0.2.0"]
```

## Usage

**REPL**

```clojure
user=> (:require 'metar)
nil
user=> (metar/parse "KSFO 042256Z 30015G22KT 10SM FEW008 19/11 A2985 RMK AO2 SLP107 T01940111")
{:airport "KSFO", :day "04", :wind-direction "300", :wind-speed-knots "15", :wind-gust-knots "22"}
```

**Project**

```clojure
(ns weather-station.core
  (:require [metar.core :as metar]))

(metar/parse "KSFO 052534Z 20023KT")
```

## Todo

- [x] Support CAVOK visibility token
- [ ] BR phenomenon was added, add rest of whatever category BR is in
- [x] Support Q---- altimiter settings

## Resources

- [Wikipedia METAR](http://en.wikipedia.org/wiki/METAR)
- [Detailed breakdown](http://www.uscg.mil/auxiliary/missions/auxair/metar_taf.pdf)
- [AIM breakdown](https://www.faa.gov/air_traffic/publications/atpubs/aim/aim0701.html#aim0701.html.62)
- [WMO Specification](http://www.wmo.int/pages/prog/www/WMOCodes/Manual/WMO306_Vol-I-1-PartA.pdf)
- [Ruby implementation](https://github.com/joeyates/metar-parser)
- [Python implementation](https://pypi.python.org/pypi/metar/1.4.0)

## License

Copyright &copy; 2014 Jeff Carpenter

Distributed under the [MIT License](LICENSE)
