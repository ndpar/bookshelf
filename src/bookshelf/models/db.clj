(ns bookshelf.models.db
  (:use [clojure.java.shell :only (sh)]))

(defn- list-files [dir]
  (clojure.string/split (:out (sh "ls" dir)) #"\n"))

(defn- parse [file]
  (when-let [match (re-matches #"([^-]+)-([^-]+)-(\d+)\.(\S+)" file)]
    (zipmap [:file :author :title :year :format] match)))

(defn- add-id [book]
  (assoc book :id (clojure.string/replace (:file book) #"[., ]" "")))

(defn books []
  (->> (list-files ".") (map parse) (remove nil?) (map add-id)))

(defn- file [id]
  (let [mapping (into {} (for [b (books)] [(:id b) (:file b)]))]
    (get mapping id)))

(defn get-file [id]
  (with-open [input  (java.io.FileInputStream. (file id))
              buffer (java.io.ByteArrayOutputStream.)]
    (clojure.java.io/copy input buffer)
    (.toByteArray buffer)))
