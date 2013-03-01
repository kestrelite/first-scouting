package tournamentftc;

import java.io.Serializable;

public class MatchFTC implements Serializable {
    private int     id = -1;
    private int     teamR1 = -1, teamR2 = -1, teamB1 = -1, teamB2 = -1;
    private int     scoreRed = -1, scoreBlue = -1;
    private boolean teamR1Def = false, teamR2Def = false, teamB1Def = false, teamB2Def = false;
    private boolean teamR1ConFail = false, teamR2ConFail = false, teamB1ConFail = false, teamB2ConFail = false;
    
    public MatchFTC(int teamR1, int teamR2, int teamB1, int teamB2) {
        this.teamR1 = teamR1; this.teamR2 = teamR2; this.teamB1 = teamB1; this.teamB2 = teamB2;
    }
    public MatchFTC(int teamR1, int teamR2, int teamB1, int teamB2, int scoreRed, int scoreBlue) {
        this.teamR1 = teamR1; this.teamR2 = teamR2; this.teamB1 = teamB1; this.teamB2 = teamB2;
        this.scoreRed = scoreRed; this.scoreBlue = scoreBlue;
    }
    
    public final void setTeams(int teamR1, int teamR2, int teamB1, int teamB2) {
        this.teamR1 = teamR1; this.teamR2 = teamR2; this.teamB1 = teamB1; this.teamB2 = teamB2;
    }
    
    public final void setScore(int scoreRed, int scoreBlue) {
        this.scoreRed = scoreRed; this.scoreBlue = scoreBlue;
    }
    
    public final void setDefense(int team, boolean defMode) {
        if(team == PositionID.R1) teamR1Def = defMode;
        if(team == PositionID.R2) teamR2Def = defMode;
        if(team == PositionID.B1) teamB1Def = defMode;
        if(team == PositionID.B2) teamB2Def = defMode;
    }
        
    protected final void setId(int id) {
        this.id = id;
    }
    
    public final void printMatchData() {
        System.out.println("R1"+(this.getR1Def()?"(D)":"(O)")+": " + this.getR1() + "; " +
        "R2"+(this.getR2Def()?"(D)":"(O)")+": " + this.getR2() + "; " + 
        "B1"+(this.getB1Def()?"(D)":"(O)")+": " + this.getB1() + "; " + 
        "B2"+(this.getB2Def()?"(D)":"(O)")+": " + this.getB2() + ". " +
        (this.getScoreBlue() > this.getScoreRed() ? 
            "Blue wins " + this.getScoreBlue() + " to " + this.getScoreRed() : 
            "Red wins " + this.getScoreRed() + " to " + this.getScoreBlue()) + ".");
    }
    
    public final int getId() {return this.id;}
    public final int getR1() {return this.teamR1;}
    public final int getR2() {return this.teamR2;}
    public final int getB1() {return this.teamB1;}
    public final int getB2() {return this.teamB2;}
    public final int getScoreRed()  {return this.scoreRed;}
    public final int getScoreBlue() {return this.scoreBlue;}
    public final boolean getR1Def() {return this.teamR1Def;}
    public final boolean getR2Def() {return this.teamR2Def;}
    public final boolean getB1Def() {return this.teamB1Def;}
    public final boolean getB2Def() {return this.teamB2Def;}
    public final boolean getR1ConFail() {return this.teamR1ConFail;}
    public final boolean getR2ConFail() {return this.teamR2ConFail;}
    public final boolean getB1ConFail() {return this.teamB1ConFail;}
    public final boolean getB2ConFail() {return this.teamB2ConFail;}
}
