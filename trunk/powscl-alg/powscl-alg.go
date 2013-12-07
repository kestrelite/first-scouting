package powalg

import (
	"fmt"
	"math"
)

const (
	winScl  = 0.9
	lossScl = 0.6
)

type Team struct {
	TeamNumber      int
	TeamName, Notes string

	PowRank, AvgScore, WinRate float32
	QP, RP                     int

	Wins, Losses int
	Strategy     []bool
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
			if t < 2 {
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
		tmp.QP = v.QP
		tmp.RP = v.RP
		tmp.Wins = v.Win
		tmp.Losses = v.Loss
		tmp.WinRate = float32(v.Win) / float32(v.Win+v.Loss)
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
			if t >= 2 {
				score = match.BScore
			}
			scl := winScl
			if (t < 2 && match.BScore > match.RScore) || (t >= 2 && match.RScore > match.BScore) {
				scl = lossScl
			}
			partavg := func() float32 {
				if t == 0 || t == 2 {
					return teamList[matchList[q].TeamNums[t+1]].AvgScore
				} else {
					return teamList[matchList[q].TeamNums[t-1]].AvgScore
				}
			}()

			teamdat.Score += float32(scl * (float64(score) - float64(partavg)))
			//fmt.Println(match, score, scl, partavg, teamdat.Score)
			teamDatMap[teamnum] = teamdat
		}
	}

	//fmt.Println(teamDatMap)

	for i, v := range teamDatMap {
		var tmp = teamList[i]
		tmp.PowRank = float32(v.Score) / float32(v.Played)
		teamList[i] = tmp
	}
	return teamList
}

type powalg interface {
	Recalculate([]Match) map[int]Team
}
