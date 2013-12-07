package main

import (
	"bytes"
	"encoding/json"
	"fmt"
)

type Team struct {
	TeamNumber int

	TeamName, Notes string

	PowRank, QP, RP   float32
	AvgScore, WinRate float32
	Wins, Losses      int
	Strategy          []bool //[Defensive, Offensive, BlockScoring, Hanging, FlagSpinner]
}

type Match struct {
	TeamNums       []int
	RScore, BScore int
	RPen, BPen     int
}

func MarshalTeams(Teams map[int]Team) string {
	mapstr := `[`
	i := 0
	for _, v := range Teams {
		val, _ := json.Marshal(v)
		mapstr += bytes.NewBuffer(val).String()
		if i != len(Teams)-1 {
			mapstr += ","
		}
		i++
	}
	mapstr += `]`
	return mapstr
}

func UnmarshalMatches(j []byte) Match {
	var m Match
	json.Unmarshal(j, &m)
	return m
}

func main() {
	teams := make(map[int]Team)

	team := Team{4278, "de.evolution", "da bestest", 4278, 4278, 4278, 4278, 4278, 4278, 0, []bool{true, false, true, true, true}}
	team1 := Team{3513, "de.evolution", "da bestest", 4278, 4278, 4278, 4278, 4278, 4278, 0, []bool{true, false, true, true, true}}
	team2 := Team{1234, "de.evolution", "da bestest", 4278, 4278, 4278, 4278, 4278, 4278, 0, []bool{true, false, true, true, true}}

	m := Match{[]int{1, 2, 3, 4}, 1, 1, 1, 1}

	teams[4278] = team
	teams[3513] = team1
	teams[1234] = team2

	z, _ := json.Marshal(m)

	fmt.Println(UnmarshalMatches(z))
}
