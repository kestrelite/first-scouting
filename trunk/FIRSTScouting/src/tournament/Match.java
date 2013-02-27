package tournament;

import java.io.Serializable;

public class Match implements Serializable {
    private int     id = -1;
    private int     teamR1 = -1, teamR2 = -1, teamB1 = -1, teamB2 = -1;
    private int     scoreRed = -1, scoreBlue = -1;
    private boolean teamR1Def = false, teamR2Def = false, teamB1Def = false, teamB2Def = false;
    private boolean finalized = false;
    private String comment = "";
    
    public Match(int teamR1, int teamR2, int teamB1, int teamB2) {
        this.teamR1 = teamR1; this.teamR2 = teamR2; this.teamB1 = teamB1; this.teamB2 = teamB2;
    }
    public Match(int teamR1, int teamR2, int teamB1, int teamB2, int scoreRed, int scoreBlue) {
        this.teamR1 = teamR1; this.teamR2 = teamR2; this.teamB1 = teamB1; this.teamB2 = teamB2;
        this.scoreRed = scoreRed; this.scoreBlue = scoreBlue;
    }
    
    public final void setTeams(int teamR1, int teamR2, int teamB1, int teamB2) {
        if(this.finalized) {System.out.println("You cannnot set teams on a finalized match!"); return;}
        this.teamR1 = teamR1; this.teamR2 = teamR2; this.teamB1 = teamB1; this.teamB2 = teamB2;
    }
    
    public final void setScore(int scoreRed, int scoreBlue) {
        this.scoreRed = scoreRed; this.scoreBlue = scoreBlue;
    }
    
    public final void setDefense(int team, boolean defMode) {
        if(team == Team.R1) teamR1Def = defMode;
        if(team == Team.R2) teamR2Def = defMode;
        if(team == Team.B1) teamB1Def = defMode;
        if(team == Team.B2) teamB2Def = defMode;
    }
    
    public final void setComment(String c) {
        this.comment = c;
    }
    
    protected final void setId(int id) {
        this.id = id;
    }
    
    protected final void finalizeMatch() {
        if(finalized) throw new Error("You cannot finalize a match twice!");
        if(id == -1) throw new Error("Match is missing ID - cannot be finalized!");
        if(teamR1 == -1 || teamR2 == -1 || teamB1 == -1 || teamB2 == -1) 
            throw new Error("Match is missing team number - cannot be finalized!");
        if(scoreRed == -1 || scoreBlue == -1)
            throw new Error("Match is missing team scores - cannot be finalized!");
        
        TeamList.getTeam(teamR1).addMatch(this);
        TeamList.getTeam(teamR2).addMatch(this);
        TeamList.getTeam(teamB1).addMatch(this);
        TeamList.getTeam(teamB2).addMatch(this);
        this.finalized = true;
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
    public final String getComment() {return this.comment;}
}
