package main

import (
	"fmt"
	"math"
)

type Team struct {
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

func main() {
	var mL []Match
	tL := make(map[int]Team)

	mL = append(mL, Match{TeamNums: []int{1, 2, 3, 4}, RScore: 50, BScore: 30, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{6, 2, 7, 4}, RScore: 30, BScore: 50, RPen: 0, BPen: 0})
	tL = UpdateTeamList(mL, tL)
	tL = PrelimCalc(mL, tL)

	fmt.Println(mL)
	fmt.Println(tL)
}
