(ns bookshelf.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]))

(def includes [(include-js "/js/jquery-1.8.2.min.js")
               (include-js "/js/jquery.tablesorter.js")
               (include-css "/css/reset.css")
               (include-css "/css/tablesorter/style.css")
               (include-css "/css/noir.css")])

(defn- build-head [header]
  `[:head
    [:title "Bookshelf"]
    ~@includes
    ~@header])

(defn- build-body [content]
  `[:body ~@content])

(defpartial layout
  [& {:keys [header content]}]
  (html5
    (build-head header)
    (build-body content)))
