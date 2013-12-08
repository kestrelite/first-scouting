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

	teamJson, _ := ioutil.ReadFile("backs/teams.json")
	matchJson, _ := ioutil.ReadFile("backs/matches.json")

	Teams = marshal.UnmarshalTeams(Teams, teamJson)
	Match = marshal.UnmarshalMatches(matchJson)

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
			w.Header().Set("Content-Type", "application/json")
			if r.Form.Get("type") == "team" {
				teamJson := r.Form.Get("data")
				tmp := marshal.UnmarshalTeam([]byte(teamJson))
				Teams[tmp.TeamNumber] = tmp
			} else if r.Form.Get("type") == "match" {
				matchJson := r.Form.Get("data")
				n, _ := strconv.Atoi(r.Form.Get("num"))
				tmp := marshal.UnmarshalMatch([]byte(matchJson))
				fmt.Println(n)
				if n > len(Match) {
					Match = append(Match, tmp)
				} else {
					Match[n-1] = tmp
				}
				Teams = powalg.Recalculate(Match)
				io.WriteString(w, marshal.MarshalTeams(Teams))
			} else if r.Form.Get("type") == "notes" {
				teamNum, _ := strconv.Atoi(r.Form.Get("num"))
				note := r.Form.Get("data")
				tmp := Teams[teamNum]
				tmp.Notes = note
				Teams[tmp.TeamNumber] = tmp
			} else if r.Form.Get("type") == "tname" {
				teamNum, _ := strconv.Atoi(r.Form.Get("num"))
				name := r.Form.Get("data")
				tmp := Teams[teamNum]
				tmp.TeamName = name
				Teams[tmp.TeamNumber] = tmp
				io.WriteString(w, marshal.MarshalTeams(Teams))
			}
		} else if r.Method == "GET" {
			w.Header().Set("Content-Type", "application/json")
			if r.Form.Get("type") == "team" {
				if r.Form.Get("num") != "all" {
					n, _ := strconv.Atoi(r.Form.Get("num"))
					io.WriteString(w, marshal.MarshalTeam(Teams[n]))
				} else {
					io.WriteString(w, marshal.MarshalTeams(Teams))
				}
			} else if r.Form.Get("type") == "match" {
				io.WriteString(w, marshal.MarshalMatch(Match))
			} else if r.Form.Get("type") == "matchNum" {
				io.WriteString(w, fmt.Sprint(len(Match)))
			} else {
				f, _ := ioutil.ReadFile("server/index.html")
				w.Header().Set("Content-Type", "text/html")
				io.WriteString(w, bytes.NewBuffer(f).String())
			}
		}
		if err := ioutil.WriteFile("backs/teams.json", []byte(marshal.MarshalTeams(Teams)), 0644); err != nil {
			fmt.Println(err)
		}
		if err := ioutil.WriteFile("backs/matches.json", []byte(marshal.MarshalMatch(Match)), 0644); err != nil {
			fmt.Println(err)
		}
	}
}
