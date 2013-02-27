package tables;

import java.sql.*;

public abstract class Table {
    protected String database;
    protected Connection con;
    protected Statement stmnt;
    
    public Table(String db) throws ClassNotFoundException, SQLException {
        this.database = db;
        Class.forName("");
        this.con = DriverManager.getConnection("table:scouting:"+database);
        this.stmnt = con.createStatement();
    }
}
