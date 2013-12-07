package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"math"
)

type Team struct {
	TeamNumber int

	TeamName, Notes string

	PowRank, QP, RP   float32
	AvgScore, WinRate float32
	Wins, Losses      int
	Strategy          []bool
}

type Match struct {
	TeamNums       []int
	RScore, BScore int
	RPen, BPen     int
}

func UpdateTeamList(matchList []Match, oldList map[int]Team) map[int]Team {
	newList := make(map[int]Team)
	for q := 0; q < len(matchList); q++ {
		for t := 0; t < len(matchList[q].TeamNums); t++ {
			newList[matchList[q].TeamNums[t]] = oldList[matchList[q].TeamNums[t]]
		}
	}
	return newList
}

func PrelimCalc(matchList []Match, teamList map[int]Team) map[int]Team {
	type TeamTempDat struct {
		Played, Sum int
		QP, RP      int
	}
	teamDatMap := make(map[int]TeamTempDat)

	for q := 0; q < len(matchList); q++ {
		for t := 0; t < len(matchList[q].TeamNums); t++ {
			var teamnum = matchList[q].TeamNums[t]
			var teamdat = teamDatMap[teamnum]
			teamdat.Played++
			var match = matchList[q]

			teamdat.RP += int(math.Min(float64(match.RScore), float64(match.BScore)))
			if q < 3 {
				teamdat.Sum += match.RScore - match.RPen
				if match.RScore > match.BScore {
					teamdat.QP += 2
				}
			} else {
				teamdat.Sum += match.BScore - match.BPen
				if match.BScore > match.RScore {
					teamdat.QP += 2
				}
			}

			teamDatMap[teamnum] = teamdat
		}
	}

	for i, v := range teamDatMap {
		var tmp = teamList[i]
		tmp.AvgScore = float32(v.Sum) / float32(v.Played)
		tmp.QP = float32(v.QP)
		tmp.RP = float32(v.RP)
		teamList[i] = tmp
	}

	return teamList
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

func main() {
	var mL []Match
	teams := make(map[int]Team)

	team := Team{4278, "de.evolution", "da bestest", 4278, 4278, 4278, 4278, 4278, 4278, 0, []bool{true, false}}
	team1 := Team{3513, "de.evolution", "da bestest", 4278, 4278, 4278, 4278, 4278, 4278, 0, []bool{true, false}}
	team2 := Team{1234, "de.evolution", "da bestest", 4278, 4278, 4278, 4278, 4278, 4278, 0, []bool{true, false}}

	teams[4278] = team
	teams[3513] = team1
	teams[1234] = team2

	tL := make(map[int]Team)

	mL = append(mL, Match{TeamNums: []int{1, 2, 3, 4}, RScore: 50, BScore: 30, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{6, 2, 7, 4}, RScore: 30, BScore: 50, RPen: 0, BPen: 0})
	tL = UpdateTeamList(mL, tL)
	tL = PrelimCalc(mL, tL)

	t := MarshalTeams(teams)

	fmt.Println(t)
}
