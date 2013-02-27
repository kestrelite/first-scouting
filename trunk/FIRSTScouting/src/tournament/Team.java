package tournament;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {
    public static final int R1 = 1;
    public static final int R2 = 2;
    public static final int B1 = 3;
    public static final int B2 = 4;
    
    private final int teamNum;
    
    private       ArrayList<Match> matchList = new ArrayList<>();
    private       String comment;
    
    public Team(int teamNum) {
        this.teamNum = teamNum;
    }
    
    public void addMatch(Match m) {
        this.matchList.add(m);
        this.calcData();
    }
    
    private void calcData() {
        
    }
    
    public int getId() {return teamNum;}
    public ArrayList<Match> getMatchList() {return matchList;}
}
