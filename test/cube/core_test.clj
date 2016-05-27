(ns cube.core-test
  (:use midje.sweet)
  (:require [cube.core :as c]))


(fact "I can construct a position from an edge and a position value"
  (:edge (c/make-position [:a :b] 0.6)) => #{:a :b}
  (:position (c/make-position [:a :b] 0.6)) => 0.6)


(fact "I can tell the closest corners on my edge"
  (c/closest-corners (c/make-position [:a :b] 0.6)) => #{:b}
  (c/closest-corners (c/make-position [:a :b] 0.2)) => #{:a}
  (c/closest-corners (c/make-position [:a :b] 1/2)) => #{:a :b}
  (c/closest-corners (c/make-position [:a :b] 0)) => #{:a}
  (c/closest-corners (c/make-position [:a :b] 1)) => #{:b}
  )

(fact "I throw an exception when the position isn't in [0.0,1.0]"
  (c/make-position [:a :b] -3) => throws #"in \[0.0"
  (c/make-position [:a :b] 12.3) => throws #"in \[0.0"
  )