(ns bookshelf.views.books
  (:require [bookshelf.models.db :as db]
            [bookshelf.views.common :as common])
  (:use [noir.core :only [defpage]]
        [noir.response :only [content-type]]
        [hiccup.element :only [link-to]]))

(defn- list-books []
  [:table.tablesorter {:id "bookTable"}
   [:thead
    [:tr
     [:th "Author"]
     [:th "Title"]
     [:th "Published"]
     [:th "Format"]]]
   (into [:tbody]
         (for [book (db/books)]
           [:tr
            [:td (:author book)]
            [:td (:title book)]
            [:td (:year book)]
            [:td (link-to (clojure.string/join "/" ["/books" (:id book) (:format book)])
                          (:format book))]]))])

(defpage "/books" []
  (common/layout
    [:h1 "Books"]
    (list-books)))

(defn- ctype [format]
  (if (= "pdf" format) "application/pdf" "text/plain"))

(defpage "/books/:id/:format" {:keys [id format]}
  (content-type (ctype format) (java.io.ByteArrayInputStream. (db/get-file id))))
