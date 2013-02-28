package tournament;

import java.io.Serializable;
import java.util.ArrayList;

public class MatchList implements Serializable {
    private MatchList() {}

    private static ArrayList<Match> matchList = new ArrayList<>();
    
    public static int addMatch(Match m) {
        m.setId(matchList.size());
        m.finalizeMatch();
        matchList.add(m);
        
        return matchList.size()-1;
    }
    
    public static Match getMatch(int id) {return matchList.get(id);}
    
    public static void printMatchData() {
        for(Match m : matchList) {
            m.printMatchData();
        }
    }
    
    public static int[][] calcTeamData() {
        ArrayList<Integer> teamList    = new ArrayList<>();
        ArrayList<Double>  teamAvgList = new ArrayList<>();
        ArrayList<Integer> matchCtList = new ArrayList<>();
        
        {ArrayList<Integer> sumList = new ArrayList<>();
            for(Match m : matchList) {
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
                    {int j = sumList.get(teamList.indexOf(m.getR2())).intValue(); sumList.set(teamList.indexOf(m.getR2()), j+m.getScoreRed());}
                    {int j = matchCtList.get(teamList.indexOf(m.getR2())).intValue(); matchCtList.set(teamList.indexOf(m.getR2()), j + 1);}
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
            
            for(int i = 0; i < teamList.size(); i++)
                teamAvgList.add(i, ((double)sumList.get(i).doubleValue())/((double)matchCtList.get(i).doubleValue()));
        }
        
        
        
        int[][] out = new int[2][teamList.size()];
        for(int i = 0; i < teamList.size(); i++) {
            out[0][i] = teamList.get(i).intValue();
            out[1][i] = (int)teamAvgList.get(i).doubleValue();
        }
        return out;
    }
}
