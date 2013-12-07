package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"math"
)

const (
	winScl  = 0.7
	lossScl = 0.4
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
		Win, Loss   int
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
					teamdat.Win++
				} else {
					teamdat.Loss++
				}
			} else {
				teamdat.Sum += match.BScore - match.BPen
				if match.BScore > match.RScore {
					teamdat.QP += 2
					teamdat.Win++
				} else {
					teamdat.Loss++
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
		tmp.Wins = v.Win
		tmp.Losses = v.Loss
		teamList[i] = tmp
	}

	return teamList
}

func ScoreCalc(matchList []Match, teamList map[int]Team) map[int]Team {
	type TempTeamDat struct {
		Score  float32
		Played int
	}
	teamDatMap := make(map[int]TempTeamDat)

	for q := 0; q < len(matchList); q++ {
		for t := 0; t < len(matchList[q].TeamNums); t++ {
			var teamnum = matchList[q].TeamNums[t]
			var teamdat = teamDatMap[teamnum]
			teamdat.Played++
			var match = matchList[q]

			score := match.RScore
			if t >= 3 {
				score = match.BScore
			}
			scl := winScl
			if (t < 3 && match.BScore > match.RScore) || (t >= 3 && match.RScore > match.BScore) {
				scl = lossScl
			}
			partavg := func() float32 {
				if t == 1 || t == 3 {
					return teamList[matchList[q].TeamNums[t-1]].AvgScore
				} else {
					return teamList[matchList[q].TeamNums[t+1]].AvgScore
				}
			}()

			teamdat.Score += float32(scl * (float64(score) - float64(partavg)))
			teamDatMap[teamnum] = teamdat
		}
	}

	fmt.Println(teamDatMap)
	return teamList
}

func main() {
	var mL []Match
	teams := make(map[int]Team)

	team := Team{4278, "de.evolution", "da bestest", 4278, 4278, 4278, 4278, 4278, 4278, 0, []bool{true, false, true, true, true}}
	team1 := Team{3513, "de.evolution", "da bestest", 4278, 4278, 4278, 4278, 4278, 4278, 0, []bool{true, false, true, true, true}}
	team2 := Team{1234, "de.evolution", "da bestest", 4278, 4278, 4278, 4278, 4278, 4278, 0, []bool{true, false, true, true, true}}

	teams[4278] = team
	teams[3513] = team1
	teams[1234] = team2

	tL := make(map[int]Team)

	mL = append(mL, Match{TeamNums: []int{1, 2, 3, 4}, RScore: 50, BScore: 30, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{1, 3, 2, 4}, RScore: 50, BScore: 30, RPen: 0, BPen: 0})
	tL = UpdateTeamList(mL, tL)
	tL = PrelimCalc(mL, tL)
	//tL = ScoreCalc(mL, tL)

	t := MarshalTeams(teams)

	fmt.Println(t)
}
