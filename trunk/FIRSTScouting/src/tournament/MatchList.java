package tournament;

import java.io.Serializable;
import java.util.ArrayList;

public class MatchList implements Serializable {
    private static ArrayList<Match> matchList = new ArrayList<>();
    
    public static int addMatch(Match m) {
        m.setId(matchList.size());
        m.finalizeMatch();
        matchList.add(m);
        
        return matchList.size()-1;
    }
    
    public static Match getMatch(int id) {return matchList.get(id);}
}
