package server

import (
	"bytes"
	"io"
	"io/ioutil"
	"net/http"
	"strings"
)

var chttp = http.NewServeMux()

func StartServer() {
	chttp.Handle("/", http.FileServer(http.Dir("C:/Users/Yousuf/Desktop/first-scouting/server")))

	http.HandleFunc("/", handler) // homepage
	http.ListenAndServe(":4278", nil)
}

func handler(w http.ResponseWriter, r *http.Request) {
	if strings.Contains(r.URL.Path, ".") {
		chttp.ServeHTTP(w, r)
	} else {
		f, _ := ioutil.ReadFile("C:/Users/Yousuf/Desktop/first-scouting/server/template.html")
		w.Header().Set("Content-Type", "text/html")
		io.WriteString(w, bytes.NewBuffer(f).String())
	}
}
