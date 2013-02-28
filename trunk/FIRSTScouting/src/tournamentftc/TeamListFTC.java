package tournamentftc;

import java.io.Serializable;
import java.util.ArrayList;

public class TeamListFTC implements Serializable {
    private static ArrayList<TeamFTC> teamList = new ArrayList<>();
    
    public static TeamFTC getTeam(int id) {
        for(int i = 0; i < teamList.size(); i++) {
            if(teamList.get(i).getId() == id) return teamList.get(i);
        }
        teamList.add(new TeamFTC(id));
        return teamList.get(teamList.size()-1);
    }
    
    public static void addTeam(int id) {
        teamList.add(new TeamFTC(id));
    }
    
    public static void delTeam(int id) {
        for(int i = 0; i < teamList.size(); i++)
            if(teamList.get(i).getId() == id) teamList.remove(i);
    }
    
    public static void printTeamData() {
        for(TeamFTC t : teamList ) {
            System.out.println("Team: " + t.getId());
            for(MatchFTC m : t.getMatchList()) {
                System.out.print("\tMatch " + m.getId() + ": ");
                m.printMatchData();
            }
        }
    }

    private TeamListFTC() {
    }
}
