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
    
    //private String URL = "jdbc:oracle:thin:system/fail1982@localhost:1521:xe"; //this string is not used
    
    private final String dbtype = "jdbc:oracle:thin:"; //leave this string alone
    
    //changing the below information maybe needed to access your database.
    private String userName = "system";  //user name for entering your database
    private String userPassword = "fail1982";  //password to enter your database
    private String hostIP = "@localhost";  //this could also be an ip address.  with a local server you can just use @localhost
    private String port = "1521"; //this is the port that your DB server is using
    private String dbName = "xe"; //this is the name you give your DB, XE is the defualt oracle 11g lite
    //this string combines your information to create the connection URL
    private String otherURL = dbtype + userName +"/"+ userPassword + hostIP  +":"+ port +":"+ dbName;
    
    public GetConnection() {
    //keep this empty
    }
    
    public void getDBConnection() {
        try {
            Connection conn = DriverManager.getConnection(otherURL);
            out.println("DB Connection Made");
        } catch(SQLException ex) {
            out.println(ex);
            out.println("did not connect to DB");
        }
    }
}
