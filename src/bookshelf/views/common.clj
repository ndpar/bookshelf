(ns bookshelf.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5]]))

(defpartial layout [& content]
  (html5
    [:head
     [:title "Bookshelf"]
     (include-css "/css/reset.css")
     (include-css "/css/noir.css")]
    [:body
     [:div#wrapper
      content]]))
