package tournamentftc;

import java.io.Serializable;
import java.util.ArrayList;

public class MatchListFTC implements Serializable {
    private MatchListFTC() {}

    private static ArrayList<MatchFTC> matchList = new ArrayList<>();
    
    public static int addMatch(MatchFTC m) {
        m.setId(matchList.size());
        m.finalizeMatch();
        matchList.add(m);
        
        return matchList.size()-1;
    }
    
    public static MatchFTC getMatch(int id) {return matchList.get(id);}
    
    public static void printMatchData() {
        for(MatchFTC m : matchList) {
            m.printMatchData();
        }
    }
    
    public static int[][] calcTeamData() {
        ArrayList<Integer> teamList    = new ArrayList<>();
        ArrayList<Double>  teamAvgList = new ArrayList<>();
        ArrayList<Double>  teamWtdList = new ArrayList<>();
        ArrayList<Integer> matchCtList = new ArrayList<>();
        
        //BEGIN PART I CALCULATION
        
        {ArrayList<Integer> sumList = new ArrayList<>();
            for(MatchFTC m : matchList) {
                if((m.getB1ConFail()?1:0) + (m.getB2ConFail()?1:0) + 
                        (m.getR1ConFail()?1:0) + (m.getR2ConFail()?1:0) > 1) continue;

                if(!teamList.contains(m.getR1())) {teamList.add(m.getR1()); sumList.add(0); matchCtList.add(0);}
                if(!teamList.contains(m.getR2())) {teamList.add(m.getR2()); sumList.add(0); matchCtList.add(0);}
                if(!teamList.contains(m.getB1())) {teamList.add(m.getB1()); sumList.add(0); matchCtList.add(0);}
                if(!teamList.contains(m.getB2())) {teamList.add(m.getB2()); sumList.add(0); matchCtList.add(0);}
                
                if(!m.getR1ConFail()) {
                    {int j = matchCtList.get(teamList.indexOf(m.getR1())).intValue(); matchCtList.set(teamList.indexOf(m.getR1()), j + 1);}
                    {int j = sumList.get(teamList.indexOf(m.getR1())).intValue(); sumList.set(teamList.indexOf(m.getR1()), j+m.getScoreRed());}
                }
                
                if(!m.getR2ConFail()) {
                    {int j = matchCtList.get(teamList.indexOf(m.getR2())).intValue(); matchCtList.set(teamList.indexOf(m.getR2()), j + 1);}
                    {int j = sumList.get(teamList.indexOf(m.getR2())).intValue(); sumList.set(teamList.indexOf(m.getR2()), j+m.getScoreRed());}
                }
                
                if(!m.getB1ConFail()) {
                    {int j = matchCtList.get(teamList.indexOf(m.getB1())).intValue(); matchCtList.set(teamList.indexOf(m.getB1()), j + 1);}
                    {int j = sumList.get(teamList.indexOf(m.getB1())).intValue(); sumList.set(teamList.indexOf(m.getB1()), j+m.getScoreBlue());}
                }
                
                if(!m.getB2ConFail()) {
                    {int j = sumList.get(teamList.indexOf(m.getB2())).intValue(); sumList.set(teamList.indexOf(m.getB2()), j+m.getScoreBlue());}
                    {int j = matchCtList.get(teamList.indexOf(m.getB2())).intValue(); matchCtList.set(teamList.indexOf(m.getB2()), j + 1);}
                }
            }
            
            for(int i = 0; i < teamList.size(); i++) {
                teamAvgList.add(i, ((double)sumList.get(i).doubleValue())/((double)matchCtList.get(i).doubleValue()));
                //System.out.println("a["+i+"]:"+teamAvgList.get(i).doubleValue());
            }
        }

        //BEGIN PART II CALCULATION
        
        {ArrayList<Double> sumList = new ArrayList<>();
            sumList.ensureCapacity(teamList.size());
            for(int i = 0; i < teamList.size(); i++) sumList.add(0.0);
            
            for(MatchFTC m : matchList) {
                if((m.getB1ConFail()?1:0) + (m.getB2ConFail()?1:0) + 
                        (m.getR1ConFail()?1:0) + (m.getR2ConFail()?1:0) > 1) continue;
                
                double bScale, rScale;
                if(m.getScoreBlue() > m.getScoreRed()) {
                    bScale = .6; rScale = .45;
                } else {bScale = .45; rScale = .6;}
                
                {
                    int index = teamList.indexOf(m.getB1());
                    double currSum = sumList.get(index).doubleValue();
                    double nextSum = (double)((double)currSum + (double)m.getScoreBlue() - ((double)teamAvgList.get(teamList.indexOf(m.getB2())).doubleValue() * bScale));
                    //System.out.println("*B1* Index:" + index + ", Team:" + teamList.get(index).intValue() + ", mcScore:" + m.getScoreBlue() + ", bScale:"+bScale+", avgAlly:" + teamAvgList.get(teamList.indexOf(m.getB2())) + ", currSum:" + currSum + ", nextSum:" + nextSum);
                    sumList.set(index, nextSum);
                }
                
                {
                    int index = teamList.indexOf(m.getB2());
                    double currSum = sumList.get(index).doubleValue();
                    double nextSum = (double)currSum + (double)m.getScoreBlue() - ((double)teamAvgList.get(teamList.indexOf(m.getB1())).doubleValue() * bScale);
                    //System.out.println("*B2* Index:" + index + ", Team:" + teamList.get(index).intValue() + ", mcScore:" + m.getScoreBlue() + ", bScale:"+bScale+", avgAlly:" + teamAvgList.get(teamList.indexOf(m.getB1()))+", currSum:" + currSum + ", nextSum:" + nextSum);
                    sumList.set(index, nextSum);
                }

                {
                    int index = teamList.indexOf(m.getR1());
                    double currSum = sumList.get(index).doubleValue();
                    double nextSum = (double)((double)currSum + (double)m.getScoreRed() - ((double)teamAvgList.get(teamList.indexOf(m.getR2())).doubleValue() * rScale));
                    //System.out.println("*R1* Index:" + index + ", Team:" + teamList.get(index).intValue() + ", mcScore:" + m.getScoreBlue() + ", rScale:"+rScale+", avgAlly:" + teamAvgList.get(teamList.indexOf(m.getR2()))+", currSum:" + currSum + ", nextSum:" + nextSum);
                    sumList.set(index, nextSum);
                }
                
                {
                    int index = teamList.indexOf(m.getR2());
                    double currSum = sumList.get(index).doubleValue();
                    double nextSum = (double)((double)currSum + (double)m.getScoreRed() - ((double)teamAvgList.get(teamList.indexOf(m.getR1())).doubleValue() * rScale));
                    //System.out.println("*R2* Index:" + index + ", Team:" + teamList.get(index).intValue() + ", mcScore:" + m.getScoreBlue() + ", rScale:"+rScale+", avgAlly:" + teamAvgList.get(teamList.indexOf(m.getR1()))+", currSum:" + currSum + ", nextSum:" + nextSum);
                    sumList.set(index, nextSum);
                }
                
                //for(int i = 0; i < sumList.size(); i++) 
                //    System.out.println("sl["+i+"]:"+sumList.get(i).doubleValue());
            }
            
            for(int i = 0; i < sumList.size(); i++) {
                teamWtdList.add(i, ((double)sumList.get(i).doubleValue())/((double)matchCtList.get(i).doubleValue()));
                //System.out.println("Wt:"+teamWtdList.get(i).doubleValue());
            }
        }
        
        //for(int i = 0; i < teamList.size(); i++) 
        //    System.out.println("Team: " + teamList.get(i).doubleValue() + ", AvgScore: " + teamAvgList.get(i).doubleValue());
        for(int i = 0; i < teamList.size(); i++) 
            System.out.println("Team: " + teamList.get(i).intValue() + ", \tWtdScore: " + teamWtdList.get(i).doubleValue());
        
        int[][] out = new int[2][teamList.size()];
        for(int i = 0; i < teamList.size(); i++) {
            out[0][i] = teamList.get(i).intValue();
            out[1][i] = (int)teamWtdList.get(i).doubleValue();
        }
        return out;
    }
}