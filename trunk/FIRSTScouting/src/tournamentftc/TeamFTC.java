package tournamentftc;

import java.io.Serializable;
import java.util.ArrayList;

public class TeamFTC implements Serializable {
    public static final int R1 = 1;
    public static final int R2 = 2;
    public static final int B1 = 3;
    public static final int B2 = 4;
    
    private final int teamNum;
    
    private       ArrayList<MatchFTC> matchList = new ArrayList<>();
    private       String comment;
    
    public TeamFTC(int teamNum) {
        this.teamNum = teamNum;
    }
    
    public void addMatch(MatchFTC m) {
        this.matchList.add(m);
        this.calcData();
    }
    
    private void calcData() {
        
    }
    
    public int getId() {return teamNum;}
    public ArrayList<MatchFTC> getMatchList() {return matchList;}
}
