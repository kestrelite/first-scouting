package tournamentftc;

import java.util.ArrayList;

public class DivisionDataFTC {
    public ArrayList<Integer> teamNumber    = new ArrayList<>();
    public ArrayList<Integer> teamMatchCnt  = new ArrayList<>();
    public ArrayList<Double>  teamAvgScore  = new ArrayList<>();
    public ArrayList<Double>  teamWtdScore  = new ArrayList<>();
    public ArrayList<Double>  teamDisconPct = new ArrayList<>();
    public ArrayList<Double>  teamDefendPct = new ArrayList<>();
    public ArrayList<String>  teamComment   = new ArrayList<>();
    
    public ArrayList<MatchFTC> matchList    = new ArrayList<>();
    public ArrayList<String>   matchComment = new ArrayList<>();
    
    public void addTeam(int teamNum) {
        teamNumber.add(teamNum);
        teamMatchCnt.add(0);
        teamAvgScore.add(-1.0);
        teamWtdScore.add(-1.0);
        teamDisconPct.add(-1.0);
        teamDefendPct.add(-1.0);
        teamComment.add("None");
    }
    
    public int addMatch(MatchFTC m) {
        m.setId(matchList.size());

        if(!teamNumber.contains(m.getR1())) addTeam(m.getR1());
        if(!teamNumber.contains(m.getR2())) addTeam(m.getR2());        
        if(!teamNumber.contains(m.getB1())) addTeam(m.getB1());
        if(!teamNumber.contains(m.getB2())) addTeam(m.getB2());
        
        matchList.add(m);
        
        return matchList.size()-1;
    }
    
    public void printTeamDump() {
        for(int i = 0; i < this.teamNumber.size(); i++)
            System.out.println("Team " + this.teamNumber.get(i).intValue() + 
                    " - MatchCnt:" + this.teamMatchCnt.get(i).doubleValue() + "; " +
                    " AvgScore:" + roundTo(this.teamAvgScore.get(i).doubleValue(), 2) + "; " +
                    " WtdScore:" + roundTo(this.teamWtdScore.get(i).doubleValue(), 2) + "; " +
                    " Defends:" + roundTo(this.teamDefendPct.get(i).doubleValue() * 100.0, 2) + "%; " +
                    " Discons:" + roundTo(this.teamDisconPct.get(i).doubleValue() * 100.0, 2) + "%; " +
                    " Comment:" + this.teamComment.get(i));
    }
    
    public void printMatchDump() {
        for(int i = 0; i < this.matchList.size(); i++) 
            System.out.println("Match " + (i+1) + " - Red 1:" + 
                    this.matchList.get(i).getR1() +
                    (this.matchList.get(i).getR1Def() ? "(D)" : "") + (this.matchList.get(i).getR1ConFail() ? "(C)" : "") + "; " +
                    " Red 2:" + this.matchList.get(i).getR2() + 
                    (this.matchList.get(i).getR2Def() ? "(D)" : "") + (this.matchList.get(i).getR2ConFail() ? "(C)" : "") + "; " +
                    " Blu 1:" + this.matchList.get(i).getB1() + 
                    (this.matchList.get(i).getB1Def() ? "(D)" : "") + (this.matchList.get(i).getB1ConFail() ? "(C)" : "") + "; " +
                    " Blu 2:" + this.matchList.get(i).getB2() + 
                    (this.matchList.get(i).getB2Def() ? "(D)" : "") + (this.matchList.get(i).getB2ConFail() ? "(C)" : "") + "; " +
                    " Red Score:" + this.matchList.get(i).getScoreRed() + "; Blu Score:" + this.matchList.get(i).getScoreBlue()+".");
    }
    
    public double roundTo(double d, int place) {
        return (double)(((double)Math.round(d * Math.pow(10, place))) / ((double)Math.pow(10, place)));
    }
}
