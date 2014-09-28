(defproject qualityclj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :source-paths ["src/clj" "src/cljs"]
  :resource-paths ["resources"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2311"]
                 [ring "1.3.1"]
                 [compojure "1.1.9"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [om "0.7.3"]
                 [racehub/om-bootstrap "0.3.0" :exclusions [org.clojure/clojure]]
                 [prismatic/om-tools "0.3.3" :exclusions [org.clojure/clojure]]
                 [figwheel "0.1.4-SNAPSHOT"]
                 [environ "1.0.0"]
                 [com.cemerick/piggieback "0.1.3"]
                 [weasel "0.4.0-SNAPSHOT"]
                 [com.datomic/datomic-free "0.9.4899"]
                 [clygments "0.1.1"]
                 [lein-kibit "0.0.8"]]

  :plugins [[lein-ring "0.8.11"]
            [lein-cljsbuild "1.0.3"]
            [lein-environ "1.0.0"]]

  :ring {:handler qualityclj.handler/app
         :init qualityclj.handler/init
         :destroy qualityclj.handler/destroy}

  ;; Uncomment for uberjar builds
  ;;:auto-clean false

  :cljsbuild {:builds {:app {:source-paths ["src/cljs"]
                             :compiler {:output-to     "resources/public/js/app.js"
                                        :output-dir    "resources/public/js/out"
                                        :source-map    "resources/public/js/out.js.map"
                                        :preamble      ["react/react.min.js"]
                                        :externs       ["react/externs/react.js"]
                                        :optimizations :none
                                        :pretty-print  true}}}}

  :profiles {:production {:ring {:open-browser? false
                                 :stacktraces? false
                                 :auto-reload? false}
                          :cljsbuild {:builds
                                      {:app
                                       {:compiler
                                        {:optimizations :advanced
                                         :pretty-print false}}}}}
             :dev {:repl-options {:init-ns qualityclj.repl}
                   :plugins [[lein-figwheel "0.1.4-SNAPSHOT"]]
                   :env {:is-dev true}
                   :dependencies [[ring-mock "0.1.5"]
                                  [ring/ring-devel "1.2.1"]]}

             :uberjar {:hooks [leiningen.cljsbuild]
                       :env {:production true}
                       :omit-source true
                       :aot :all
                       :cljsbuild {:builds
                                   {:app
                                    {:compiler
                                     {:optimizations :advanced
                                      :pretty-print false}}}}}})
