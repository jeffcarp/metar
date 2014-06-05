# metar

DISCLAIMER: Not done! Do not use yet!

A WMO-306 I.i.A compliant METAR weather report parser for Clojure.

METARS are frequently used for estimating runway conditions at a given airport.

## Installation

Add this to your `project.clj`

```clojure
[metar "0.1.0"]
```

## Usage

**REPL**

```clojure
user=> (:require 'metar)
nil
user=> (metar/parse "KSFO 042256Z 30015G22KT 10SM FEW008 19/11 A2985 RMK AO2 SLP107 T01940111")
{:airport "KSFO", :day "04", :wind-direction "300", :wind-speed-knots "15", :wind-gust-knots "22"}
```

## Resources

- [Wikipedia METAR](http://en.wikipedia.org/wiki/METAR)
- [Detailed breakdown](http://www.uscg.mil/auxiliary/missions/auxair/metar_taf.pdf)
- [WMO Specification](http://www.wmo.int/pages/prog/www/WMOCodes/Manual/WMO306_Vol-I-1-PartA.pdf)
- [Ruby implementation](https://github.com/joeyates/metar-parser)
- [Python implementation](https://pypi.python.org/pypi/metar/1.4.0)

## License

Copyright &copy; 2014 Jeff Carpenter

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
