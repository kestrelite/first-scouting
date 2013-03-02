package firstscouting;

import gui.DivisionGUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import tournamentftc.DivisionDataFTC;
import tournamentftc.MatchFTC;

public class FIRSTScouting {
    public static void runFile(String fName) throws Exception {
        Scanner s;
        DivisionDataFTC d = new DivisionDataFTC();
        
        File f = new File(fName);
        
        if(f.exists()) {
            FileInputStream fs = new FileInputStream(fName);
            InputStreamReader is = new InputStreamReader(fs);
            s = new Scanner(is);

            while(s.hasNext()) d.addMatch(new MatchFTC(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt()));
            s.nextLine();
            
            d.calcAll();
            d.printMatchDump(); System.out.println(""); d.printTeamDump();
            
            //MatchListFTC.calcTeamData();
            
            System.exit(0);
        }
        if(1==1) throw new Error("File does not exist!");
    }
    
    public static void runCmdLine() {
        Scanner s; DivisionDataFTC d = new DivisionDataFTC();
        s = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Team R1: "); int r1 = s.nextInt();
                System.out.print("Team R2: "); int r2 = s.nextInt();
                System.out.print("Team B1: "); int b1 = s.nextInt();
                System.out.print("Team B2: "); int b2 = s.nextInt();
                System.out.print("Score R: "); int rS = s.nextInt();
                System.out.print("Score B: "); int bS = s.nextInt();
                d.addMatch(new MatchFTC(r1, r2, b1, b2, rS, bS));

                d.printMatchDump();
                d.printTeamDump();

                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input detected - restarting iteration...\n");
                s = new Scanner(System.in);
                continue;
            }
        }        
    }
    
    public static void runRawData() {
        DivisionDataFTC d = new DivisionDataFTC();
        
        d.addMatch(new MatchFTC(1, 2, 3, 4, 80, 30));
        d.addMatch(new MatchFTC(2, 3, 4, 5, 60, 20));
        d.addMatch(new MatchFTC(3, 4, 5, 1, 40, 90));
        d.addMatch(new MatchFTC(4, 5, 1, 2, 50, 75));
        
        d.calcTeamMatchCnt();
        d.calcTeamAvg();
        d.calcTeamWtd();
        
        d.printTeamDump();
    }
    
    public static void runGUI(String fName) throws Exception 
    {
        Scanner s;
        DivisionDataFTC d = new DivisionDataFTC();
        
        File f = new File(fName);
        
        if(f.exists()) {
            FileInputStream fs = new FileInputStream(fName);
            InputStreamReader is = new InputStreamReader(fs);
            s = new Scanner(is);

            while(s.hasNext()) d.addMatch(new MatchFTC(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt()));
            s.nextLine();
            
            d.calcAll();
            DivisionGUI dGUI = new DivisionGUI(d);
        } else System.out.println("File does not exist");
    }
    
    public static void main(String[] args) throws Exception {
        //FIRSTScouting.runFile("L:\\FIRSTScouting\\src\\[Documents]\\tScores.txt");
        //FIRSTScouting.runFile("C:\\Users\\Noah\\Desktop\\tScores.txt");
        //FIRSTScouting.runFile("C:\\Users\\sutton-smolinn3979\\Desktop\\first-scouting\\FIRSTScouting\\src\\[Documents]\\tScores.txt");
        //FIRSTScouting.runCmdLineDivision();
        FIRSTScouting.runGUI("/home/nom/NetBeansProjects/FIRSTScouting/src/[Documents]/tScores.txt");
    }
}
