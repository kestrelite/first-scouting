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
    public ArrayList<Boolean>  matchInvalid = new ArrayList<>();
    
    public String divisionName = "";
    
    public DivisionDataFTC(String name) {}
    public DivisionDataFTC() {}
    
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

        matchList.add(m); matchComment.add("None"); matchInvalid.add(Boolean.FALSE);
        return matchList.size()-1;
    }
    
    public void printTeamDump() {
        for(int i = 0; i < this.teamNumber.size(); i++)
            System.out.println("Team " + this.teamNumber.get(i).intValue() + 
                    " - \tMatchCnt:" + this.teamMatchCnt.get(i).doubleValue() + "; \t" +
                    " AvgScore:" + roundTo(this.teamAvgScore.get(i).doubleValue(), 2) + "; \t" +
                    " WtdScore:" + roundTo(this.teamWtdScore.get(i).doubleValue(), 2) + "; \t" +
                    " Defends:" + roundTo(this.teamDefendPct.get(i).doubleValue() * 100.0, 2) + "%; \t" +
                    " Discons:" + roundTo(this.teamDisconPct.get(i).doubleValue() * 100.0, 2) + "%; \t" +
                    " Comment:" + this.teamComment.get(i));
    }
    public void printMatchDump() {
        for(int i = 0; i < this.matchList.size(); i++) 
            System.out.println("Match " + (i+1) + "(" + (this.matchList.get(i).getScoreBlue() > this.matchList.get(i).getScoreRed() ? "B" : "R") + ") - \tRed 1:" + 
                    this.matchList.get(i).getR1() +
                    (this.matchList.get(i).getR1Def() ? "(D)" : "") + (this.matchList.get(i).getR1ConFail() ? "(C)" : "") + "; \t" +
                    " Red 2:" + this.matchList.get(i).getR2() + 
                    (this.matchList.get(i).getR2Def() ? "(D)" : "") + (this.matchList.get(i).getR2ConFail() ? "(C)" : "") + "; \t" +
                    " Blu 1:" + this.matchList.get(i).getB1() + 
                    (this.matchList.get(i).getB1Def() ? "(D)" : "") + (this.matchList.get(i).getB1ConFail() ? "(C)" : "") + "; \t" +
                    " Blu 2:" + this.matchList.get(i).getB2() + 
                    (this.matchList.get(i).getB2Def() ? "(D)" : "") + (this.matchList.get(i).getB2ConFail() ? "(C)" : "") + "; \t" +
                    " Red Score:" + this.matchList.get(i).getScoreRed() + "; \tBlu Score:" + this.matchList.get(i).getScoreBlue()+".");
    }
    
    public void setDiscon (int matchNum, int teamNum, boolean discon) {this.matchList.get(matchNum).setConFail(teamNum, discon);}
    public void setDefense(int matchNum, int teamNum, boolean defend) {this.matchList.get(matchNum).setDefense(teamNum, defend);}
    public void setTeamComment (int teamNum, String com)  {this.teamComment.set(this.teamNumber.indexOf(teamNum), com);}
    public void setMatchComment(int matchNum, String com) {this.matchComment.set(matchNum, com);}
    
    protected void setTeamDisconPct(ArrayList<Double>  d) {this.teamDisconPct = d;}
    protected void setTeamDefendPct(ArrayList<Double>  d) {this.teamDefendPct = d;}
    protected void setTeamAvgScore (ArrayList<Double>  d) {this.teamAvgScore  = d;}
    protected void setTeamWtdScore (ArrayList<Double>  d) {this.teamWtdScore  = d;}
    protected void setTeamMatchCnt (ArrayList<Integer> d) {this.teamMatchCnt  = d;}
    
    public boolean getTeamMatchDefend (int matchNum, int teamNum) {return this.matchList.get(matchNum).getConFail(teamNum);}
    public boolean getTeamMatchConFail(int matchNum, int teamNum) {return this.matchList.get(matchNum).getDefend(teamNum);}
    public int     getTeamPlayedCnt(int teamNum) {return this.teamMatchCnt.get(this.teamNumber.indexOf(teamNum)).intValue();}
    public double  getTeamDisconPct(int teamNum) {return this.teamDisconPct.get(this.teamNumber.indexOf(teamNum));}
    public double  getTeamDefendPct(int teamNum) {return this.teamDefendPct.get(this.teamNumber.indexOf(teamNum));}
    public double  getTeamAvgScore(int teamNum) {return this.teamAvgScore.get(this.teamNumber.get(teamNum));}
    public double  getTeamWtdScore(int teamNum) {return this.teamWtdScore.get(this.teamNumber.get(teamNum));}
    public String  getTeamComment(int teamNum) {return this.teamComment.get(this.teamNumber.indexOf(teamNum));}
    public String  getMatchComment(int matchNum) {return this.matchComment.get(matchNum);}
    public boolean getMatchIsValid(int matchNum) {
        MatchFTC m = this.matchList.get(matchNum);
        if(matchInvalid.get(matchNum).booleanValue()) return false;
        if((m.getB1Def()?1:0) + (m.getB2Def()?1:0) + (m.getR1Def()?1:0) + (m.getR2Def()?1:0) > 1) return false;
        if((m.getB1ConFail()?1:0) + (m.getB2ConFail()?1:0) + (m.getR1ConFail()?1:0) + (m.getR2ConFail()?1:0) > 1) return false;
        return true;
    }
    public boolean getMatchIsValid(MatchFTC m) {return getMatchIsValid(this.matchList.indexOf(m));}
    
    public double roundTo(double d, int place) {return (double)(((double)Math.round(d * Math.pow(10, place))) / ((double)Math.pow(10, place)));}    
    
    public void calcTeamAvg() {
        ArrayList<Integer> teamNumList = new ArrayList<>();
        ArrayList<Integer> sumList = new ArrayList<>();
        ArrayList<Integer> cntList = new ArrayList<>();

        for (MatchFTC m : this.matchList) {
            if (!this.getMatchIsValid(m)) continue;

            if (!teamNumList.contains(m.getR1())) {
                sumList.add(0);
                cntList.add(0);
                teamNumList.add(m.getR1());
            }

            if (!teamNumList.contains(m.getR2())) {
                sumList.add(0);
                cntList.add(0);
                teamNumList.add(m.getR2());
            }

            if (!teamNumList.contains(m.getB1())) {
                sumList.add(0);
                cntList.add(0);
                teamNumList.add(m.getB1());
            }

            if (!teamNumList.contains(m.getB2())) {
                sumList.add(0);
                cntList.add(0);
                teamNumList.add(m.getB2());
            }

            if (!m.getR1ConFail()) {
                sumList.set(teamNumList.indexOf(m.getR1()), sumList.get(teamNumList.indexOf(m.getR1())) + m.getScoreRed());
                cntList.set(teamNumList.indexOf(m.getR1()), cntList.get(teamNumList.indexOf(m.getR1())) + 1);
            }
            
            if (!m.getR2ConFail()) {
                sumList.set(teamNumList.indexOf(m.getR2()), sumList.get(teamNumList.indexOf(m.getR2())) + m.getScoreRed());
                cntList.set(teamNumList.indexOf(m.getR2()), cntList.get(teamNumList.indexOf(m.getR2())) + 1);
            }
            
            if (!m.getB1ConFail()) {
                sumList.set(teamNumList.indexOf(m.getB1()), sumList.get(teamNumList.indexOf(m.getB1())) + m.getScoreRed());
                cntList.set(teamNumList.indexOf(m.getB1()), cntList.get(teamNumList.indexOf(m.getB1())) + 1);
            }
            
            if (!m.getB2ConFail()) {
                sumList.set(teamNumList.indexOf(m.getB2()), sumList.get(teamNumList.indexOf(m.getB2())) + m.getScoreRed());
                cntList.set(teamNumList.indexOf(m.getB2()), cntList.get(teamNumList.indexOf(m.getB2())) + 1);
            }
        }
        
        
        ArrayList<Double> outs = new ArrayList<>();
        for(int i = 0; i < this.teamNumber.size(); i++)
            outs.add(sumList.get(teamNumList.indexOf(this.teamNumber.get(i))).doubleValue() 
                    / cntList.get(teamNumList.indexOf(this.teamNumber.get(i))).doubleValue());
        this.setTeamAvgScore(outs);
    }
}
