# Bookshelf

A Clojure web application that transforms a directory full of e-books to a web library. E-book files must be in the format `Author-Title-Year.FileExtension`.

## Usage

* Grab the latest JAR from [Downloads](https://github.com/ndpar/bookshelf/downloads) or build from sources (see below)
* Copy the JAR to the directory with books
* Run `java -jar bookshelf-0.1.0-standalone.jar`
* Load the app into the browser: [http://localhost:8080/books](http://localhost:8080/books)
* Choose the book and click on the link in the last column

![Bookshelf](http://3.bp.blogspot.com/-GEGxO0TtKwA/UJsACInthyI/AAAAAAAAHLM/vmijwB7D3XI/s800/bookshelf2.png)

## Build

    lein uberjar

## License

Copyright (C) 2012 Andrey Paramonov

Distributed under the Eclipse Public License, the same as Clojure.
