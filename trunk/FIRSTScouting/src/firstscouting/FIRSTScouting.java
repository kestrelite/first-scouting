package firstscouting;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.UIManager;
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
            
            d.calcTeamAvg();
            d.calcTeamMatchCnt();
            d.calcTeamWtd();
            d.printMatchDump(); System.out.println(""); d.printTeamDump();

            //MatchListFTC.calcTeamData();
            
            System.exit(0);
        }
        if(1==1) throw new Error("File does not exist!");
    }
    
    /*public static void runCmdLine() {
        Scanner s;        
        s = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Team R1: "); int r1 = s.nextInt();
                System.out.print("Team R2: "); int r2 = s.nextInt();
                System.out.print("Team B1: "); int b1 = s.nextInt();
                System.out.print("Team B2: "); int b2 = s.nextInt();
                System.out.print("Score R: "); int rS = s.nextInt();
                System.out.print("Score B: "); int bS = s.nextInt();
                MatchListFTC.addMatch(new MatchFTC(r1, r2, b1, b2, rS, bS));

                MatchListFTC.printMatchData();
                TeamListFTC.printTeamData();
                int[][] data = MatchListFTC.calcTeamData();

                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input detected - restarting iteration...\n");
                s = new Scanner(System.in);
                continue;
            }
        }        
    }*/
    
    public static void runCmdLineDivision() {
        DivisionDataFTC d = new DivisionDataFTC();
        
        d.addMatch(new MatchFTC(1, 2, 3, 4, 50, 60));
        
        d.printMatchDump(); System.out.println(""); d.printTeamDump();
    }
    
    public static void runGUI() throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        FIRSTScoutingDisp display = new FIRSTScoutingDisp();        
    }
    
    public static void main(String[] args) throws Exception {
        FIRSTScouting.runFile("C:\\Users\\Noah\\Desktop\\tScores.txt");
        //FIRSTScouting.runCmdLineDivision();
    }
}
