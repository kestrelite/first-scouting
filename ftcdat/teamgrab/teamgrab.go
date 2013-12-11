package main

import (
	"fmt"
	"github.com/PuerkitoBio/goquery" //Requires Library: "go get github.com/PuerkitoBio/goquery"
	"log"
	"os"
	"strings"
)

const (
	reg  = ".*?<.*?<.*?<.*?(<)(table)(\\s+)(class)(=)(\"sticky-enabled\")(>).*?(<\\/table>)"
	base = `http://www.usfirst.org/whats-going-on/teams?ProgramCode=FTC&Season=2013&Country=USA&StateProv=&ZipCode=&Radius=&op=Searchsort=asc&order=Team%20Number`
)

var (
	start    = "Team,Team_Name\n"
	current  = ""
	prevNum  = ""
	firstURL = `http://www.usfirst.org/whats-going-on/teams?ProgramCode=FTC&Season=2013&Country=USA&StateProv=&ZipCode=92014&Radius=100&op=Searchsort=asc&order=Team%20Number`
)

func parsePage(i int, m *goquery.Selection) {
	prevNum = m.Find("a").Text()
	// if len(prevNum) > 4 {
	// 	prevNum = string(prevNum[4:])
	// }
	current += fmt.Sprintf("%s,%s\n", prevNum, m.FindNodes(m.Nodes[0].FirstChild.NextSibling.NextSibling.NextSibling).Text())
}

func getPages(m string) {
	for i := 0; true; i++ {
		page, err := goquery.NewDocument(fmt.Sprintf("%s&page=%d", m, i))
		if err != nil {
			log.Fatalln(err)
		}
		page.Find("table.sticky-enabled").Find("tbody").Find("tr").Each(parsePage)
		if strings.Contains(start, prevNum) {
			//fmt.Println(prevNum)
			break
		} else {
			start += current
			current = ""
		}
		//fmt.Printf("Done parsing page %d...\n", i)
	}
}

func setURL(z, r, d string) {
	firstURL = `http://www.usfirst.org/whats-going-on/teams?ProgramCode=` + d + `&Season=2013&Country=USA&StateProv=&ZipCode=` + z + `&Radius=` + r + `&op=Searchsort=asc&order=Team%20Number`
}

func main() {
	zip := "92014"
	radius := "50"
	division := "FTC"
	if len(os.Args) >= 2 {
		zip = os.Args[1]
	}
	if len(os.Args) >= 3 {
		radius = os.Args[2]
	}
	if len(os.Args) >= 4 {
		division = os.Args[3]
	}

	setURL(zip, radius, division)

	getPages(firstURL)
	fmt.Print(start, "\n")
}
