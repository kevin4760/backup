/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCon;

import static java.lang.System.out;
import java.sql.*;

/**
 * GetConnection.java
 * @author Kevin
 * creates a DB Connection for the specific database in the String 
 * URL.  This connection string must be manually changed as of right now
 */
public class GetConnection {
    
    //this string is broke into these "jdbc:oracle:thin:username:passowrd@location:port:databasename
    private String URL = "jdbc:oracle:thin:system/fail1982@localhost:1521:xe";
    
    public GetConnection() {
    //keep this empty
    }
    
    public void getDBConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            out.println("DB Connection Made");
        } catch(SQLException ex) {
            out.println(ex);
            out.println("did not connect to DB");
        }
    }
}
