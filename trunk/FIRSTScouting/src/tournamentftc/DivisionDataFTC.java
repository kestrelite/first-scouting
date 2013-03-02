package tournamentftc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class DivisionDataFTC implements Serializable {
    public ArrayList<Integer> teamNumber    = new ArrayList<>();
    public ArrayList<Integer> teamMatchCnt  = new ArrayList<>();
    public ArrayList<Double>  teamAvgScore  = new ArrayList<>();
    public ArrayList<Double>  teamWtdScore  = new ArrayList<>();
    public ArrayList<Double>  teamDisconPct = new ArrayList<>();
    public ArrayList<Double>  teamDefendPct = new ArrayList<>();
    public ArrayList<Integer> teamQualifyPt = new ArrayList<>();
    public ArrayList<Integer> teamRankingPt = new ArrayList<>();
    public ArrayList<String>  teamComment   = new ArrayList<>();
    
    public ArrayList<MatchFTC> matchList    = new ArrayList<>();
    public ArrayList<String>   matchComment = new ArrayList<>();
    
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
    public int  addMatch(MatchFTC m) {
        m.setId(matchList.size());

        if(!teamNumber.contains(m.getR1())) addTeam(m.getR1());
        if(!teamNumber.contains(m.getR2())) addTeam(m.getR2());        
        if(!teamNumber.contains(m.getB1())) addTeam(m.getB1());
        if(!teamNumber.contains(m.getB2())) addTeam(m.getB2());

        matchList.add(m); matchComment.add("None"); //matchInvalid.add(Boolean.FALSE);
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
    
    protected void setTeamNumber  (ArrayList<Integer> d)  {this.teamNumber = d;}
    protected void setTeamComment (ArrayList<String> d)   {this.teamComment = d;}
    protected void setMatchList   (ArrayList<MatchFTC> d) {this.matchList = d;}
    protected void setMatchComment(ArrayList<String> d)   {this.matchComment = d;}
    
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
        if((m.getB1Def()?1:0) + (m.getB2Def()?1:0) + (m.getR1Def()?1:0) + (m.getR2Def()?1:0) > 1) return false;
        if((m.getB1ConFail()?1:0) + (m.getB2ConFail()?1:0) + (m.getR1ConFail()?1:0) + (m.getR2ConFail()?1:0) > 1) return false;
        return true;
    }
    public boolean getMatchIsValid(MatchFTC m) {return getMatchIsValid(this.matchList.indexOf(m));}
    
    public void calcAll() {
        this.calcTeamMatchCnt();
        this.calcTeamTournamentScore();
        this.calcTeamDefendsPct();
        this.calcTeamConFailPct();
        this.calcTeamAvg();
        this.calcTeamWtd();
    }
    public void calcTeamAvg() {
        ArrayList<Integer> sumList = this.newEmptyIntList(this.teamNumber.size());
        this.teamAvgScore = this.newEmptyDoubleList(this.teamNumber.size());
        
        for (MatchFTC m : this.matchList) {
            if (!this.getMatchIsValid(m)) continue;

            if (!m.getR1ConFail()) sumList.set(this.teamNumber.indexOf(m.getR1()), sumList.get(teamNumber.indexOf(m.getR1())) + m.getScoreRed());
            if (!m.getR2ConFail()) sumList.set(this.teamNumber.indexOf(m.getR2()), sumList.get(teamNumber.indexOf(m.getR2())) + m.getScoreRed());
            if (!m.getB1ConFail()) sumList.set(this.teamNumber.indexOf(m.getB1()), sumList.get(teamNumber.indexOf(m.getB1())) + m.getScoreBlue());
            if (!m.getB2ConFail()) sumList.set(this.teamNumber.indexOf(m.getB2()), sumList.get(teamNumber.indexOf(m.getB2())) + m.getScoreBlue());
        }
        
        ArrayList<Double> outs = new ArrayList<>();
        for(int i = 0; i < this.teamNumber.size(); i++)
            outs.add(sumList.get(teamNumber.indexOf(this.teamNumber.get(i))).doubleValue() 
                    / this.teamMatchCnt.get(teamNumber.indexOf(this.teamNumber.get(i))).doubleValue());
        this.teamAvgScore = outs;
    }
    public void calcTeamMatchCnt() {
        this.teamMatchCnt = this.newEmptyIntList(this.teamNumber.size());
        
        for(MatchFTC m : this.matchList) {
            if(!this.getMatchIsValid(m)) continue;
            teamMatchCnt.set(this.teamNumber.indexOf(m.getB1()), teamMatchCnt.get(this.teamNumber.indexOf(m.getB1())) + 1);
            teamMatchCnt.set(this.teamNumber.indexOf(m.getB2()), teamMatchCnt.get(this.teamNumber.indexOf(m.getB2())) + 1);
            teamMatchCnt.set(this.teamNumber.indexOf(m.getR1()), teamMatchCnt.get(this.teamNumber.indexOf(m.getR1())) + 1);
            teamMatchCnt.set(this.teamNumber.indexOf(m.getR2()), teamMatchCnt.get(this.teamNumber.indexOf(m.getR2())) + 1);
        }
    }    
    public void calcTeamWtd() {
        ArrayList<Double> sumList = this.newEmptyDoubleList(this.teamNumber.size());
        
        for(MatchFTC m : this.matchList) {
            if(!this.getMatchIsValid(m)) continue;
            
            double bScale, rScale, defScale = 0.25;
            if(m.getScoreBlue() > m.getScoreRed()) {bScale = 0.70; rScale = 0.35;}
            else {bScale = 0.35; rScale = 0.70;}
            
            int index = this.teamNumber.indexOf(m.getB1());
            if(m.getB1Def()) {sumList.set(index, sumList.get(index).doubleValue() + defScale * ((this.getTeamAvgScore(m.getR1())) + this.getTeamAvgScore(m.getR2())/2.0 - (double)m.getScoreRed()));}
            else if(m.getB2Def()) {sumList.set(index, sumList.get(index).doubleValue() + m.getScoreBlue() * bScale);}
            else {sumList.set(index, (double)((double)sumList.get(index).doubleValue() + (double)m.getScoreBlue() - ((double)this.teamAvgScore.get(this.teamNumber.indexOf(m.getB2())).doubleValue() * bScale)));}
            
            index = this.teamNumber.indexOf(m.getB2());
            if(m.getB2Def()) {sumList.set(index, sumList.get(index).doubleValue() + defScale * ((this.getTeamAvgScore(m.getR1())) + this.getTeamAvgScore(m.getR2())/2.0 - (double)m.getScoreRed()));}
            else if(m.getB1Def()) {sumList.set(index, sumList.get(index).doubleValue() + m.getScoreBlue() * bScale);}
            else {sumList.set(index, (double)((double)sumList.get(index).doubleValue() + (double)m.getScoreBlue() - ((double)this.teamAvgScore.get(this.teamNumber.indexOf(m.getB1())).doubleValue() * bScale)));}
            
            index = this.teamNumber.indexOf(m.getR1());
            if(m.getR1Def()) {sumList.set(index, sumList.get(index).doubleValue() + defScale * ((this.getTeamAvgScore(m.getB1())) + this.getTeamAvgScore(m.getB2())/2.0 - (double)m.getScoreBlue()));}
            else if(m.getR2Def()) {sumList.set(index, sumList.get(index).doubleValue() + m.getScoreRed() * rScale);}
            else {sumList.set(index, (double)((double)sumList.get(index).doubleValue() + (double)m.getScoreRed() - ((double)this.teamAvgScore.get(this.teamNumber.indexOf(m.getR2())).doubleValue() * rScale)));}
            
            index = this.teamNumber.indexOf(m.getR2());
            if(m.getR2Def()) {sumList.set(index, sumList.get(index).doubleValue() + defScale * ((this.getTeamAvgScore(m.getB1())) + this.getTeamAvgScore(m.getB2())/2.0 - (double)m.getScoreBlue()));}
            else if(m.getR1Def()) {sumList.set(index, sumList.get(index).doubleValue() + m.getScoreRed() * rScale);}
            sumList.set(index, (double)((double)sumList.get(index).doubleValue() + (double)m.getScoreRed() - ((double)this.teamAvgScore.get(this.teamNumber.indexOf(m.getR1())).doubleValue() * rScale)));
        }
        
        for(int i = 0; i < this.teamNumber.size(); i++) 
            this.teamWtdScore.set(i, sumList.get(i).doubleValue() / this.teamMatchCnt.get(i).doubleValue());
    }
    public void calcTeamDefendsPct() {
        ArrayList<Double> defendsPct = this.newEmptyDoubleList(this.teamNumber.size());
        for(MatchFTC m : this.matchList) {
            if(!this.getMatchIsValid(m)) continue;
            if(m.getB1Def()) defendsPct.set(this.teamNumber.indexOf(m.getB1()), defendsPct.get(this.teamNumber.indexOf(m.getB1())) + 1);
            if(m.getB2Def()) defendsPct.set(this.teamNumber.indexOf(m.getB2()), defendsPct.get(this.teamNumber.indexOf(m.getB2())) + 1);
            if(m.getR1Def()) defendsPct.set(this.teamNumber.indexOf(m.getR1()), defendsPct.get(this.teamNumber.indexOf(m.getR1())) + 1);
            if(m.getR2Def()) defendsPct.set(this.teamNumber.indexOf(m.getR2()), defendsPct.get(this.teamNumber.indexOf(m.getR2())) + 1);
        }
        
        for(int i = 0; i < this.teamNumber.size(); i++)
            this.teamDefendPct.set(i, defendsPct.get(i).doubleValue() / this.teamMatchCnt.get(i).doubleValue());
    }
    public void calcTeamConFailPct() {
        ArrayList<Double> conFail = this.newEmptyDoubleList(this.teamNumber.size());
        for(MatchFTC m : this.matchList) {
            if(!this.getMatchIsValid(m)) continue;
            if(m.getB1ConFail()) conFail.set(this.teamNumber.indexOf(m.getB1()), conFail.get(this.teamNumber.indexOf(m.getB1())) + 1);
            if(m.getB2ConFail()) conFail.set(this.teamNumber.indexOf(m.getB2()), conFail.get(this.teamNumber.indexOf(m.getB2())) + 1);
            if(m.getR1ConFail()) conFail.set(this.teamNumber.indexOf(m.getR1()), conFail.get(this.teamNumber.indexOf(m.getR1())) + 1);
            if(m.getR2ConFail()) conFail.set(this.teamNumber.indexOf(m.getR2()), conFail.get(this.teamNumber.indexOf(m.getR2())) + 1);
        }
        
        for(int i = 0; i < this.teamNumber.size(); i++)
            this.teamDisconPct.set(i, conFail.get(i).doubleValue() / this.teamMatchCnt.get(i).doubleValue());
    }
    public void calcTeamTournamentScore() {
        this.teamQualifyPt = this.newEmptyIntList(this.teamNumber.size());
        this.teamRankingPt = this.newEmptyIntList(this.teamNumber.size());
        
        for(MatchFTC m : this.matchList) {
            if(m.getScoreBlue() > m.getScoreRed()) {
                this.teamQualifyPt.set(this.teamNumber.indexOf(m.getB1()), 2 + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getB1())));
                this.teamQualifyPt.set(this.teamNumber.indexOf(m.getB2()), 2 + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getB2())));

                this.teamRankingPt.set(this.teamNumber.indexOf(m.getB1()), m.getScoreRed() + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getB1())));
                this.teamRankingPt.set(this.teamNumber.indexOf(m.getB2()), m.getScoreRed() + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getB2())));
                this.teamRankingPt.set(this.teamNumber.indexOf(m.getR1()), m.getScoreRed() + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getR1())));
                this.teamRankingPt.set(this.teamNumber.indexOf(m.getR2()), m.getScoreRed() + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getR2())));
            } else {
                this.teamQualifyPt.set(this.teamNumber.indexOf(m.getR1()), 2 + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getR1())));
                this.teamQualifyPt.set(this.teamNumber.indexOf(m.getR2()), 2 + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getR2())));
                
                this.teamRankingPt.set(this.teamNumber.indexOf(m.getB1()), m.getScoreBlue() + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getB1())));
                this.teamRankingPt.set(this.teamNumber.indexOf(m.getB2()), m.getScoreBlue() + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getB2())));
                this.teamRankingPt.set(this.teamNumber.indexOf(m.getR1()), m.getScoreBlue() + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getR1())));
                this.teamRankingPt.set(this.teamNumber.indexOf(m.getR2()), m.getScoreBlue() + this.teamQualifyPt.get(this.teamNumber.indexOf(m.getR2())));
            }
        }
    }
    
    private ArrayList<Integer> newEmptyIntList(int length) {
        ArrayList<Integer> out = new ArrayList<>();
        for(int i = 0; i < length; i++) out.add(0);
        return out;
    }
    private ArrayList<Double> newEmptyDoubleList(int length) {
        ArrayList<Double> out = new ArrayList<>();
        for(int i = 0; i < length; i++) out.add(0.0);
        return out;
    }

    public void sortTeamData(int[] indexOrder) {
        ArrayList<Integer> teamNumberNew = new ArrayList<>();
        ArrayList<Integer> teamMatchCntNew = new ArrayList<>();
        ArrayList<Double> teamAvgScoreNew = new ArrayList<>();
        ArrayList<Double> teamWtdScoreNew = new ArrayList<>();
        ArrayList<Double> teamDisconPctNew = new ArrayList<>();
        ArrayList<Double> teamDefendPctNew = new ArrayList<>();
        ArrayList<Integer> teamQualifyPtNew = new ArrayList<>();
        ArrayList<Integer> teamRankingPtNew = new ArrayList<>();
        ArrayList<String> teamCommentNew = new ArrayList<>();
        
        for(int i = 0; i < indexOrder.length; i++) {
            teamNumberNew.add(this.teamNumber.get(indexOrder[i]));
            teamMatchCntNew.add(this.teamMatchCnt.get(indexOrder[i]));
            teamAvgScoreNew.add(this.teamAvgScore.get(indexOrder[i]));
            teamWtdScoreNew.add(this.teamWtdScore.get(indexOrder[i]));
            teamDisconPctNew.add(this.teamDisconPct.get(indexOrder[i]));
            teamDefendPctNew.add(this.teamDefendPct.get(indexOrder[i]));
            teamQualifyPtNew.add(this.teamQualifyPt.get(indexOrder[i]));
            teamRankingPtNew.add(this.teamRankingPt.get(indexOrder[i]));
            teamCommentNew.add(this.teamComment.get(indexOrder[i]));
        }
        
        this.teamNumber = teamNumberNew;
        this.teamMatchCnt = teamMatchCntNew;
        this.teamAvgScore = teamAvgScoreNew;
        this.teamWtdScore = teamWtdScoreNew;
        this.teamDisconPct = teamDisconPctNew;
        this.teamDefendPct = teamDefendPctNew;
        this.teamQualifyPt = teamQualifyPtNew;
        this.teamRankingPt = teamRankingPtNew;
        this.teamComment = teamCommentNew;
    }
    public double roundTo(double d, int place) {return (double)(((double)Math.round(d * Math.pow(10, place))) / ((double)Math.pow(10, place)));}    
    
    public void writeToFile(String path) {
        File f = new File(path);
        if(f.exists()) f.delete();
        
        try {
            OutputStream fileOut = new FileOutputStream(path);
            OutputStream bufferOut = new BufferedOutputStream(fileOut);
            ObjectOutput output = new ObjectOutputStream(bufferOut);
            
            output.writeObject(this);
        } catch(IOException e) {}
    }
    
    public static DivisionDataFTC readFromFile(String path) {
        try {
            InputStream fileIn = new FileInputStream(path);
            InputStream bufferIn = new BufferedInputStream(fileIn);
            ObjectInput input = new ObjectInputStream(bufferIn);
            
            return (DivisionDataFTC)input.readObject();
        } catch(Exception e) {
            System.out.println(path);
            e.printStackTrace();
        }
        
        if(1==1) throw new Error("Could not read DivisionDataFTC at " + path);
        return null;
    }
}