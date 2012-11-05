(ns bookshelf.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]
        [hiccup.element :only [javascript-tag]]))

(defpartial layout [& content]
  (html5
    [:head
     [:title "Bookshelf"]
     (include-js "/js/jquery-1.8.2.min.js")
     (include-js "/js/jquery.tablesorter.js")
     (include-css "/css/reset.css")
     (include-css "/css/tablesorter/style.css")
     (include-css "/css/noir.css")
     (javascript-tag "$(document).ready(function() {$(\"#bookTable\").tablesorter();});")]
    [:body
     [:div#wrapper
      content]]))
