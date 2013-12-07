package main

import (
	"fmt"
	//"math"
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
		Sum, QP, RP int
	}
	teamDatList := make(map[int]TeamTempDat)

	for q := 0; q < len(matchList); q++ {
		for t := 0; q < len(matchList[q].TeamNums); t++ {
			var teamnum = matchList[q].TeamNums[t]
			var match = matchList[q]
			//teamDatList[teamnum].Sum += func() { matchList[q].RScore }
		}
	}
}

func main() {
	var mL []Match
	tL := make(map[int]Team)

	mL = append(mL, Match{TeamNums: []int{1, 2, 3, 4}, RScore: 50, BScore: 30, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{6, 2, 7, 4}, RScore: 50, BScore: 30, RPen: 0, BPen: 0})
	tL = UpdateTeamList(mL, tL)

	fmt.Println(mL)
	fmt.Println(tL)
}
