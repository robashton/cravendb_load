(ns cravendb_load.core
   (require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clojure.string :refer [trim]]))

(defn read-float [in i]
  (Float/parseFloat (get in i)))

(defn read-int [in i]
  (int (read-float in i)))

(defn read-str [in i]
  (trim (get in i)))

(defn prescription-row [in]
  {
   :sha  (read-str in 0)
   :pct (read-str in 1)
   :practice (read-str in 2)
   :bnf-code (read-str in 3)
   :bnf-chemical (read-str in 4)
   :bnf-name (read-str in 5)
   :items (read-float in 6)
   :net-ingredient-cost (read-float in 7)
   :act-cost (read-float in 8)
   :quantity (read-int in 9)
   :year (read-int in 10)
   :month (read-int in 11)
   }
)

#_ (with-open [in-file (io/reader "input/prescriptions/adhd/part-00000")]
     (first (map prescription-row (csv/read-csv in-file))))

