package main

import (
	"./marshal"
	"./powscl-alg"
	"bytes"
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"strconv"
	"strings"
)

var chttp = http.NewServeMux()
var Teams map[int]powalg.Team
var Match []powalg.Match

func main() {
	Teams = make(map[int]powalg.Team)

	Match = append(Match, powalg.Match{[]int{1, 2, 3, 4}, 1, 1, 1, 1})
	Match = append(Match, powalg.Match{[]int{4, 3, 2, 1}, 1, 1, 1, 1})

	t1 := powalg.Team{4278, "de.evolution", "da bestest", 1, 1, 1, 1, 1, 1, 1, []bool{true, true, true, true, true}}
	t2 := powalg.Team{3513, "de.evolution", "da bestest", 1, 1, 1, 1, 1, 1, 1, []bool{true, true, true, true, true}}

	Teams[4278] = t1
	Teams[3513] = t2

	chttp.Handle("/", http.FileServer(http.Dir("server")))

	http.HandleFunc("/", handler)
	panic(http.ListenAndServe(":4278", nil))
}

func handler(w http.ResponseWriter, r *http.Request) {
	if strings.Contains(r.URL.Path, ".") {
		chttp.ServeHTTP(w, r)
	} else {
		r.ParseForm()
		if r.Method == "POST" {
			if r.Form.Get("type") == "team" {
				teamJson := r.Form.Get("data")
				tmp := marshal.UnmarshalTeam([]byte(teamJson))
				Teams[tmp.TeamNumber] = tmp
				fmt.Println(Teams)
			} else if r.Form.Get("type") == "match" {
				matchJson := r.Form.Get("data")
				n, _ := strconv.Atoi(r.Form.Get("num"))
				tmp := marshal.UnmarshalMatch([]byte(matchJson))
				if n > len(Match) {
					Match = append(Match, tmp)
				} else {
					Match[n-1] = tmp
				}
				fmt.Println(Match)
			}
		} else if r.Method == "GET" {
			w.Header().Set("Content-Type", "application/json")
			if r.Form.Get("type") == "team" {
				if r.Form.Get("num") != "all" {
					n, _ := strconv.Atoi(r.Form.Get("num"))
					io.WriteString(w, marshal.MarshalTeam(Teams[n]))
				}
			} else if r.Form.Get("type") == "match" {
				io.WriteString(w, marshal.MarshalMatch(Match))
			} else {
				f, _ := ioutil.ReadFile("server/template.html")
				w.Header().Set("Content-Type", "text/html")
				io.WriteString(w, bytes.NewBuffer(f).String())
			}
		}
	}
}
