package ftcdat

import (
	"../powscl-alg"
	"encoding/csv"
	"fmt"
	"io"
	"os"
	"strconv"
)

func NameCorrect(Teams map[int]powalg.Team) map[int]powalg.Team {
	f, _ := os.Open("ftcdat/2013TeamNames.csv")
	defer f.Close()
	r := csv.NewReader(f)
	r.Comma = ','
	for {
		record, error := r.Read()
		if error == io.EOF {
			break
		} else if error != nil {
			fmt.Println("Error:", error)
			break
		}
		num, _ := strconv.Atoi(record[0])
		name := record[1]
		_, exists := Teams[num]
		if exists {
			tmp := Teams[num]
			tmp.TeamName = name
			Teams[num] = tmp
		}
	}
	return Teams
}
