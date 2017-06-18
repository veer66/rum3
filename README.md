# rum3

rum3 is an example of figwheel + rum + ring + bidi usages.

## Generation

rum3 is generated from
````
lein new figwheel rum3 -- --rum

````


## In cljs

I replace defonce with def in order to change web instantly.

## Server side

I just added server.clj in src/rum3

````Clojure
(ns rum3.server
  (:require [bidi.ring :refer (make-handler)]
            [bidi.bidi :refer (url-decode)]
            [ring.util.response :as res]
            [clojure.string :as str]
            [ring.util.response :as res]
            [clojure.java.io :as io])
  
  (:use ring.middleware.resource
        ring.middleware.params)
  
  (:gen-class))


(defn index-handler
  [req]
  (res/response "Gaga"))

(def handler
  (make-handler ["/" {"radio" index-handler}]))

(def app (->
          handler))
````

It uses ring and bidi so I added more dependencies in project.clj:


````Clojure
[bidi "2.0.17"]
[ring "1.5.0"]

````


## Figwheel config

I also use Figwheel to handle Ring by adding this line in project.clj:


````Clojure
:ring-handler rum3.server/app
````


## Test


Run:

````Clojure
lein figwheel
````

This project can be tested by visiting http://localhost:3449 for client side and http://localhost:3449/radio for server side

You can try to edit core.cljs. The web should be changed instantly. By editing server.clj, after reloading you can see /radio change.
