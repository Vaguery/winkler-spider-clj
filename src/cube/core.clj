(ns cube.core)

(def cube
  "  a----------b
     |          |
     |   e--f   |
     |   |  |   |
     |   h--g   |
     |          |
     d----------c
  "
    { :corners  [:a :b :c :d :e :f :g :h]
      :edges    (map #(apply sorted-set %)
                  [[:a :b] [:b :c] [:c :d] [:a :d]
                  [:a :e] [:b :f] [:c :g] [:d :h]
                  [:e :f] [:f :g] [:g :h] [:e :h]])
      :branches {:a #{:b :d :e}
                 :b #{:a :c :f}
                 :c #{:b :d :g}
                 :d #{:a :c :h}
                 :e #{:a :f :h}
                 :f #{:b :e :g}
                 :g #{:c :f :h}
                 :h #{:d :e :g}}})

(defrecord Position [edge position])


(defn valid-position?
  [number]
  (and
    (<= 0 number)
    (>= 1 number)))


(defn make-position
  [corners position]
  (if-not (valid-position? position)
    (throw (Exception. "position must be in [0.0,1.0]"))
    (->Position (apply sorted-set corners) position)))


(defn closest-corners
  [where]
  (let [e (:edge where)
        p (:position where)]
    (cond
      (< p 1/2) #{(first e)}
      (> p 1/2) #{(second e)}
      :else (into #{} e)
      )))
