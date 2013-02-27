/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yousuf
 */
public class WeightTable extends Table {

    public WeightTable(String db) throws ClassNotFoundException, SQLException {
        super(db);
        stmnt.executeUpdate("create table if not exists weight(ID int,value int);");
    }

    public void insert(int ID, int value) throws SQLException {
        PreparedStatement prep = con.prepareStatement(
                "insert into weight values(?,?);");
        prep.setInt(1, ID);
        prep.setInt(2, value);
        prep.addBatch();
        con.setAutoCommit(false);
        prep.executeBatch();
        con.setAutoCommit(true);
    }

    public int getValue(int ID) throws SQLException {
        ResultSet rs;
        try {
            rs = stmnt.executeQuery("select * from weight where id=" + Integer.toString(ID));
            rs.next();
            return rs.getInt("value");
        } catch (SQLException ex) {
            this.insert(ID, 100);
            return 100;
        }
    }

    public Map<Integer, Integer> getValues() throws SQLException {
        ResultSet rs = stmnt.executeQuery("select * from weight");
        Map<Integer, Integer> values = new HashMap<Integer, Integer>();
        while (rs.next()) {
            Integer key;
            Integer value;
            key = rs.getInt("ID");
            value = rs.getInt("value");
            values.put(key, value);
        }
        return values;
    }

    public void reset() throws SQLException {
        stmnt.executeUpdate("Drop table weight;");
        stmnt.executeUpdate("create table if not exists weight(ID int,value int);");
    }
}
