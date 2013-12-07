package main

import (
	"bytes"
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	http.HandleFunc("/", handler)
	http.HandleFunc("/", http.FileServer(http.Dir("C:/Users/Yousuf/Desktop/first-scouting/templateGUI")))
	panic(http.ListenAndServe(":4278", nil))
}

func handler(w http.ResponseWriter, r *http.Request) {
	f, _ := ioutil.ReadFile("template.html")
	fmt.Fprintf(w, bytes.NewBuffer(f).String())
}
