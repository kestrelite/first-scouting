/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentfrc;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dasty
 */
public class GatherData 
{
    public GatherData()
    {
        grabEventData("NHMA");
    }
    
    public void grabEventData(String eventID)
    {
        String data = null;
        URLConnection connection = null;
        try {
          connection =  new URL("http://www2.usfirst.org/2013comp/Events/"+eventID+"/matchresults.html").openConnection();
          Scanner scanner = new Scanner(connection.getInputStream());
          scanner.useDelimiter("\\Z");
          data = scanner.next();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        parseMatches(data);
    }
    
    public void parseMatches(String data)
    {
        String re1=".*?";	// Non-greedy match on filler
        String re2="((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM))?)";	// HourMinuteSec 1
        String re3=".*?";	// Non-greedy match on filler
        String re4="\\d+";	// Uninteresting: int
        String re5=".*?";	// Non-greedy match on filler
        String re6="\\d+";	// Uninteresting: int
        String re7=".*?";	// Non-greedy match on filler
        String re8="(\\d+)";	// Integer Number 1
        String re9=".*?";	// Non-greedy match on filler
        String re10="\\d+";	// Uninteresting: int
        String re11=".*?";	// Non-greedy match on filler
        String re12="\\d+";	// Uninteresting: int
        String re13=".*?";	// Non-greedy match on filler
        String re14="(\\d+)";	// Integer Number 2
        String re15=".*?";	// Non-greedy match on filler
        String re16="\\d+";	// Uninteresting: int
        String re17=".*?";	// Non-greedy match on filler
        String re18="\\d+";	// Uninteresting: int
        String re19=".*?";	// Non-greedy match on filler
        String re20="(\\d+)";	// Integer Number 3
        String re21=".*?";	// Non-greedy match on filler
        String re22="\\d+";	// Uninteresting: int
        String re23=".*?";	// Non-greedy match on filler
        String re24="\\d+";	// Uninteresting: int
        String re25=".*?";	// Non-greedy match on filler
        String re26="(\\d+)";	// Integer Number 4
        String re27=".*?";	// Non-greedy match on filler
        String re28="\\d+";	// Uninteresting: int
        String re29=".*?";	// Non-greedy match on filler
        String re30="\\d+";	// Uninteresting: int
        String re31=".*?";	// Non-greedy match on filler
        String re32="(\\d+)";	// Integer Number 5
        String re33=".*?";	// Non-greedy match on filler
        String re34="\\d+";	// Uninteresting: int
        String re35=".*?";	// Non-greedy match on filler
        String re36="\\d+";	// Uninteresting: int
        String re37=".*?";	// Non-greedy match on filler
        String re38="(\\d+)";	// Integer Number 6
        String re39=".*?";	// Non-greedy match on filler
        String re40="\\d+";	// Uninteresting: int
        String re41=".*?";	// Non-greedy match on filler
        String re42="\\d+";	// Uninteresting: int
        String re43=".*?";	// Non-greedy match on filler
        String re44="(\\d+)";	// Integer Number 7
        String re45=".*?";	// Non-greedy match on filler
        String re46="\\d+";	// Uninteresting: int
        String re47=".*?";	// Non-greedy match on filler
        String re48="\\d+";	// Uninteresting: int
        String re49=".*?";	// Non-greedy match on filler
        String re50="(\\d+)";	// Integer Number 8
        String re51=".*?";	// Non-greedy match on filler
        String re52="\\d+";	// Uninteresting: int
        String re53=".*?";	// Non-greedy match on filler
        String re54="\\d+";	// Uninteresting: int
        String re55=".*?";	// Non-greedy match on filler
        String re56="(\\d+)";	// Integer Number 9

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11+re12+re13+re14+re15+re16+re17+re18+re19+re20+re21+re22+re23+re24+re25+re26+re27+re28+re29+re30+re31+re32+re33+re34+re35+re36+re37+re38+re39+re40+re41+re42+re43+re44+re45+re46+re47+re48+re49+re50+re51+re52+re53+re54+re55+re56,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        while(data.indexOf("<TR style=\"background-color:#FFFFFF;\" >") != -1)
        {
            String txt= data.substring(data.indexOf("<TR style=\"background-color:#FFFFFF;\" >"),data.indexOf("</TR>", data.indexOf("<TR style='background-color:#FFFFFF;' >"))+5);
            Matcher m = p.matcher(txt);
            if (m.find())
            {
                String time=m.group(1);
                String matchNum=m.group(2);
                String R1=m.group(3);
                String R2=m.group(4);
                String R3=m.group(5);
                String B1=m.group(6);
                String B2=m.group(7);
                String B3=m.group(8);
                String scoreRed=m.group(9);
                String scoreBlue=m.group(10);
                System.out.println("Time: "+time.toString()+" - "+"Match: "+matchNum.toString()+" - "+"Red1: "+R1.toString()+" - "+"Red2: "+R2.toString()+" - "+"Red3: "+R3.toString()+" - "+"Blue1: "+B1.toString()+" - "+"Blue2: "+B2.toString()+" - "+"Blue3: "+B3.toString()+" - "+"Red Score: "+scoreRed.toString()+" - "+"Blue Score: "+scoreBlue.toString());
            }
            data = data.substring(data.indexOf("</TR>")+5);
        }
    }
    
    public static void main(String args[])
    {
        new GatherData();
    }
}
