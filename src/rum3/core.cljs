(ns rum3.core
  (:require [rum.core :as rum]))

(enable-console-print!)

(println "This text is printed from src/rum3/core.cljs. Go ahead and edit it and see reloading in action.")

(def app-state (atom {:text "Pressure!"}))

(rum/defc hello-world []
    [:h1 (:text @app-state)])

(rum/mount (hello-world)
           (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
