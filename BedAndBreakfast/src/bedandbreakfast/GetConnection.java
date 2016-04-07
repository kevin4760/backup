/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast;

import java.util.*;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * GetConnection.java
 * @author Kevin
 * @modification Prasanna
 * creates a DB Connection for the specific database in the String 
 * URL.  This connection string must be manually changed as of right now
 */
public class GetConnection{
    private Connection conn;
//    private Properties connectionProps;
    private String username;
    private String password;
    private String schema;
    private String server;
    private int port;
    private String URL;
    private Statement stmt;
    private ResultSet rs;
    
    public GetConnection(String username, String password, String schema, String server, int port) {
        this.username = username;
        this.password = password;
        this.schema = schema;
        this.server = server;
        this.port = port;
//        connectionProps = new Properties();
//        connectionProps.put("user", username);
//        connectionProps.put("password", password);
    }
    
    public void getDBConnection(){
        //this string is broke into these "jdbc:oracle:thin:username:passowrd@location:port:databasename
        //jdbc:oracle:thin:@server:port:schema
        URL = "jdbc:oracle:thin:" + "@" + server + ":" + port +
                ":" + schema;
        //System.out.println(URL);
        try {
            conn = DriverManager.getConnection(URL, username, password);
            System.out.println("DB Connection Made");
        } catch(SQLException ex) {
            //System.out.println(ex.getMessage());
            showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("did not connect to DB");
        }
    }
    
    public ArrayList runquery(String query){
        ArrayList records = new ArrayList();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                //rs.getType();
                //int size = rs.getFetchSize();
                int size = 1;
                System.out.println(size);
                for (int i = 1; i <= size; i++){
                    records.add(rs.getString(i));
                }
            }
        } catch (SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return records;
    }
}
