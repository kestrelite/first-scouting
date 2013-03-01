package tournamentftc;

import java.util.ArrayList;

public class Calculation {
    private Calculation() {}

    public static void calcTeamAvg(DivisionDataFTC d) {
        ArrayList<Integer> teamNumList = new ArrayList<>();
        ArrayList<Integer> sumList = new ArrayList<>();
        ArrayList<Integer> cntList = new ArrayList<>();

        for (MatchFTC m : d.matchList) {
            if (!d.getMatchIsValid(m)) {
                continue;
            }

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
        for(int i = 0; i < d.teamNumber.size(); i++)
            outs.add(sumList.get(teamNumList.indexOf(d.teamNumber.get(i))).doubleValue() 
                    / cntList.get(teamNumList.indexOf(d.teamNumber.get(i))).doubleValue());
        d.setTeamAvgScore(outs);
    }
}
