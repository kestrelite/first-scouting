package main

import (
	"fmt"
)

type Match struct {
	TeamsRed  []int
	TeamsBlue []int

	RScore, BScore int
	MatchNotes     string
}

type Team struct {
	TeamNum              int
	WinCt, LossCt, TieCt int

	PowRank, AvgScore, WinRate float32
}

func buildTeamList(matchList []Match) *map[int]Team {
	teamMap := make(map[int]Team)
	for _, match := range matchList {
		for _, team := range append(match.TeamsRed, match.TeamsBlue...) {
			if _, ok := teamMap[team]; !ok {
				t := new(Team)
				t.TeamNum = team
				teamMap[team] = *t
			}
		}

		if match.RScore == match.BScore {
			for _, team := range append(match.TeamsRed, match.TeamsBlue...) {
				teamMap[team].TieCt += 1
			}
		} else {
			var win, loss = []int{0}, []int{0}
			if match.RScore > match.BScore {
				win = match.TeamsRed
				loss = match.TeamsBlue
			} else {
				win = match.TeamsBlue
				loss = match.TeamsRed
			}

			for _, team := range win {
				teamMap[team].WinCt += 1
			}
			for _, team := range loss {
				teamMap[team].LossCt += 1
			}
		}
	}
	return &teamMap
}

func Recalculate(matchList []Match) {
	fmt.Print(buildTeamList(matchList))
}

func main() {
	mList := *new([]Match)
	mList = append(mList, Match{TeamsRed: []int{100, 200}, TeamsBlue: []int{300, 400}, RScore: 100, BScore: 200, MatchNotes: "Example A"})
	mList = append(mList, Match{TeamsRed: []int{200, 400}, TeamsBlue: []int{100, 500}, RScore: 150, BScore: 100, MatchNotes: "Example B"})
	Recalculate(mList)
}
