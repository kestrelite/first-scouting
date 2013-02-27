package tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchTable extends Table {

    public MatchTable(String db) throws ClassNotFoundException, SQLException {
        super(db);
        stmnt.executeUpdate("Create Table IF no match exists (int Team, int ID,"
                + " int value)");
    }

    public void insert(int team, int ID, int value) throws SQLException {
        PreparedStatement prep = con.prepareStatement("INSERT into match values");
        prep.setInt(1, team);
        prep.setInt(2, ID);
        prep.setInt(3, value);

        prep.addBatch();

        con.setAutoCommit(false);
        prep.executeBatch();
        con.setAutoCommit(true);
    }

    public Map<Integer, Integer> getVals(int team) throws SQLException {
        ResultSet rs = stmnt.executeQuery("Select * from match where team=" + Integer.toString(team));
        Map<Integer, Integer> values = new HashMap<>();
        while (rs.next()) {
            Integer key, value;
            key = rs.getInt("value");
            value = rs.getInt("ID");
            values.put(key, value);
        }
        return values;
    }

    public List<Integer> getValues(int team, int ID) throws SQLException {
        ResultSet rs = stmnt.executeQuery("select * from match where team=" + Integer.toString(team) + "and ID=" + Integer.toString(ID));
        List<Integer> values = new ArrayList<Integer>();
        while (rs.next()) {
            Integer value;
            value = rs.getInt("value");
            values.add(value);
        }

        return values;

    }

    public int getAverageValue(int team, int ID) throws SQLException {
        List<Integer> values = this.getValues(team, ID);
        int sum = 0;
        for (Integer i : values) {
            sum += i;
        }

        int average = (values.size() == 0) ? 0 : sum / (values.size());
        return average;

    }

    public List<Integer> getTeams() throws SQLException {
        ResultSet rs = stmnt.executeQuery("select distinct team from match");
        List<Integer> teams = new ArrayList<Integer>();
        while (rs.next()) {
            Integer team;
            team = rs.getInt("team");
            teams.add(team);
        }
        Collections.sort(teams);
        return teams;
    }

    public void reset() throws SQLException {
        stmnt.executeUpdate("Drop table match;");
        stmnt.executeUpdate("create table if not exists match(team int,ID int,value int);");
    }
}
