(ns bookshelf.views.books
  (:require [bookshelf.views.common :as common])
  (:use [noir.core :only [defpage]]))

(defpage "/books" []
  (common/layout
    [:p "Welcome to bookshelf"]))
