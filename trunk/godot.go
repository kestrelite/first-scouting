package main

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

func main() {
	var mL []Match
	tL := make(map[int]Team)

	mL = append(mL, Match{TeamNums: []int{7423, 395, 4134, 6950}, RScore: 139, BScore: 55, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{4433, 5944, 6508, 3795}, RScore: 149, BScore: 95, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{7056, 6191, 118, 7314}, RScore: 51, BScore: 68, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{4999, 61, 230, 365}, RScore: 108, BScore: 117, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{7055, 4399, 4977, 4347}, RScore: 97, BScore: 166, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{6191, 61, 7423, 3795}, RScore: 75, BScore: 76, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{4999, 5944, 4347, 118}, RScore: 189, BScore: 179, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{395, 4977, 6508, 365}, RScore: 71, BScore: 193, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{230, 7314, 6950, 4399}, RScore: 144, BScore: 57, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{7055, 4134, 7056, 4433}, RScore: 102, BScore: 140, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{6950, 6508, 6191, 4347}, RScore: 104, BScore: 66, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{230, 395, 7314, 4433}, RScore: 96, BScore: 148, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{4399, 118, 4134, 61}, RScore: 111, BScore: 84, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{3795, 7056, 4999, 4977}, RScore: 55, BScore: 108, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{365, 7423, 5944, 7055}, RScore: 122, BScore: 64, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{4433, 6191, 4999, 4399}, RScore: 166, BScore: 152, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{3795, 118, 395, 7055}, RScore: 60, BScore: 137, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{61, 6950, 4977, 5944}, RScore: 147, BScore: 103, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{6508, 7423, 230, 7056}, RScore: 153, BScore: 169, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{365, 4347, 7314, 4134}, RScore: 176, BScore: 81, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{4433, 4977, 7423, 118}, RScore: 183, BScore: 32, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{365, 6950, 4399, 3795}, RScore: 183, BScore: 112, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{5944, 4134, 230, 6191}, RScore: 68, BScore: 65, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{7056, 4347, 61, 395}, RScore: 356, BScore: 114, RPen: 0, BPen: 0})
	mL = append(mL, Match{TeamNums: []int{7314, 6508, 7055, 4999}, RScore: 84, BScore: 126, RPen: 0, BPen: 0})

	tL = UpdateTeamList(mL, tL)
	tL = PrelimCalc(mL, tL)
	tL = ScoreCalc(mL, tL)

	fmt.Println(tL)
	fmt.Println(mL)

	fmt.Println("TNum,PowScore,QP,RP,AvgScore,WinRate")

	fc := func(t float32) string {
		return fmt.Sprintf("%f", t)
	}
	ic := func(t int) string {
		return fmt.Sprint("", t)
	}
	for i, v := range tL {
		fmt.Println(ic(i) + "," + fc(v.PowRank) + "," + ic(v.QP) + "," + ic(v.RP) + "," + fc(v.AvgScore) + "," + fc(v.WinRate))
	}
}
