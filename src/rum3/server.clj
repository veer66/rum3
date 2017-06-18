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

