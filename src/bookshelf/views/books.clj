(ns bookshelf.views.books
  (:require [bookshelf.views.common :as common])
  (:use [noir.core :only [defpage]]
        [noir.response :only [content-type]]
        [hiccup.element :only [link-to]]))

(def books
  [{:author "Fogus M., Houser C."
    :title "The Joy Of Clojure"
    :year "2011"
    :format "pdf"
    :id 1}
   {:author "Fogus M., Houser C."
    :title "The Joy Of Clojure"
    :year "2011"
    :format "epub"
    :id 2}])

(defn- list-books []
  [:table
   [:thead
    [:tr
     [:th "Author"]
     [:th "Title"]
     [:th "Published"]
     [:th "Format"]]]
   (into [:tbody]
         (for [book books]
           [:tr
            [:td (:author book)]
            [:td (:title book)]
            [:td (:year book)]
            [:td (link-to (clojure.string/join "/" ["/books" (:id book) (:format book)])
                          (:format book))]]))])

(defpage "/books" []
  (common/layout
    (list-books)))

(defn get-file [id]
  nil)

(defn- ctype [format]
  (if (= "pdf" format) "application/pdf" "text/plain"))

(defpage "/books/:id/:format" {:keys [id format]}
  (content-type (ctype format) (java.io.ByteArrayInputStream. (get-file id))))
