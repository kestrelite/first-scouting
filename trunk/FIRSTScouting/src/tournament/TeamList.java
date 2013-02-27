package tournament;

import java.io.Serializable;
import java.util.ArrayList;

public class TeamList implements Serializable {
    private static ArrayList<Team> teamList = new ArrayList<>();
    
    public static Team getTeam(int id) {
        for(int i = 0; i < teamList.size(); i++) {
            if(teamList.get(i).getId() == id) return teamList.get(i);
        }
        teamList.add(new Team(id));
        return teamList.get(teamList.size()-1);
    }
    
    public static void addTeam(int id) {
        teamList.add(new Team(id));
    }
    
    public static void delTeam(int id) {
        for(int i = 0; i < teamList.size(); i++)
            if(teamList.get(i).getId() == id) teamList.remove(i);
    }
    
    public static void printTeamData() {
        for(Team t : teamList ) {
            System.out.println("Team: " + t.getId());
            for(Match m : t.getMatchList()) {
                System.out.print("\tMatch " + m.getId() + ": ");
                m.printMatchData();
            }
        }
    }
}
