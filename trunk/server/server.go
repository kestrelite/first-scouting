package server

import (
	//"../marshal"
	"bytes"
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"strings"
)

var chttp = http.NewServeMux()

func StartServer() {
	chttp.Handle("/", http.FileServer(http.Dir("server")))

	http.HandleFunc("/", handler) // homepage
	panic(http.ListenAndServe(":4278", nil))
}

func handler(w http.ResponseWriter, r *http.Request) {
	if strings.Contains(r.URL.Path, ".") {
		chttp.ServeHTTP(w, r)
	} else {
		r.ParseForm()
		if r.Method == "POST" {
			if r.Form.Get("type") == "match" {
				//matchJson := r.Form.Get("data")

			} else if r.Form.Get("type") == "team" {
				//teamJson := r.Form.Get("data")
			}
		} else if r.Method == "GET" {
			w.Header().Set("Content-Type", "application/json")

			if r.Form.Get("type") == "team" {
				//Marshal Team Struct
				fmt.Println(main.Teams[r.Form.Get("num"))
				io.WriteString(w, "This is a get team")
			} else if r.Form.Get("type") == "match" {
				//Marshal Match Struct
				io.WriteString(w, "This is a Match Get")
			} else {
				f, _ := ioutil.ReadFile("server/template.html")
				w.Header().Set("Content-Type", "text/html")
				io.WriteString(w, bytes.NewBuffer(f).String())
			}
		}
	}
}
