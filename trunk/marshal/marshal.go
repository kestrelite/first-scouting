package marshal

import (
	"../powscl-alg"
	"bytes"
	"encoding/json"
)

func MarshalTeams(Teams map[int]powalg.Team) string {
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

func UnmarshalMatches(j []byte) powalg.Match {
	var m powalg.Match
	json.Unmarshal(j, &m)
	return m
}
