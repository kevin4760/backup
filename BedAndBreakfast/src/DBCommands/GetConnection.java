/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import static java.lang.System.out;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
   
    
    //constructors
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
    //constructor to call kevins db connection
    //constructors
    public GetConnection() {
        this.username = "bbpms";
        this.password = "bbpms";
        this.schema = "orcl";
        this.server = "bbpms.ddns.net";
        this.port = 1521;
//        connectionProps = new Properties();
//        connectionProps.put("user", username);
//        connectionProps.put("password", password);
    }
    public GetConnection(int x){
        if(x == 5) {
            this.username = "system";
            this.password = "ANK22dec2010!!";
            this.schema = "xe";
            this.server = "localhost";
            this.port = 1521;
        }
        //you can add an if interger statement for yours
    }
    //end constructors
    
    public void closeConnection(){
        try{
            stmt.close();
            rs.close();
            conn.close();
        }catch (SQLException ex){
        }
    }
    //getters
    public Connection getConn() {
        return this.conn;
    }
    
    public ResultSet getRS() {
        return this.rs;
    }
    
    public Statement getStmt() {
        return this.stmt;
    }
    //end getters
    
    //setters
    public void setRS(ResultSet rs) {
        this.rs = rs;
    }
    
    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
    //end setters
    
    
    //method getDBConnection(), 
    public void getDBConnection(){
        //this string is broke into these "jdbc:oracle:thin:username:passowrd@location:port:databasename
        //jdbc:oracle:thin:@server:port:schema        
        URL = "jdbc:oracle:thin:" + "@" + server + ":" + port +
                ":" + schema;
        //System.out.println(URL);
        try {
            this.conn = DriverManager.getConnection(URL, username, password);
            //System.out.println("DB Connection Made");
        } catch(SQLException ex) {
            //System.out.println(ex.getMessage());
            showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("did not connect to DB");
        }     
    }
    
    //method validateUser()
    public Boolean validateUser(String username, String password) {
        
        Boolean access = false;
        try {
            String sql = "SELECT * FROM employees WHERE user_name='" + username + 
                "' and password='" + password +"'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                access = true;
                rs.close();
            } else 
                access = false;
                rs.close();
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return access;        
    }
    
    //Set Guest Information Method
    public void setGuestInfo(String guestNumber, String first, 
            String last, String title){
        
        try{
        String sql="INSERT INTO guests(GUEST_NO, FIRST_NAME, LAST_NAME, TITLE) "
                + "Values('"+guestNumber+"','"+first+"','"+last+"','"+title+"')";
        stmt=conn.createStatement(); 
        stmt.executeUpdate(sql);
        }   
        catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    //Set Guest Address Method
    public void setGuestAddress(String guestNumber, String street, String city, 
            String state, String zipcode){
        
        try{
            String sql="INSERT INTO addresses(GUEST_NO, STREET, CITY, STATE, ZIP) "+
                    "Values('"+guestNumber+"','"+street+"','"+city+"','"+
                    state+"','"+zipcode+"')";
            stmt=conn.createStatement();
            stmt.executeUpdate(sql);
        }
         catch(SQLException ex) {
            System.out.println(ex);
        }
    }
        
    //Set Reseration Method
    public void setReservation(String reservationNum, String roomNum, String guestNumber
    ,String inDate, String outDate, Double price){
        try{
            String sql="INSERT INTO reservations(RES_NO, RM_NO, GUEST_NO, "
                    + "IN_DATE, OUT_DATE, PRICE)Values('"+reservationNum+"','"
                    +roomNum+"','"+guestNumber+"','"+inDate+"','"+outDate+"','"
                    +price+"')";
            stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        }
         catch(SQLException ex) {
            System.out.println(ex);
        }
    }
   
    //method returns one value from database
    public int getRoomStatus(String query) {
        int roomStatus = 3; //3 will be invalid input
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            roomStatus = Integer.parseInt(rs.getString(1));
        } catch(SQLException ex) {
            out.println(ex);
        }
        return roomStatus;
    }
    
    //method getResults(), Prasana returning DB info to ArrayList
    public ArrayList getresults(String query, int column_size){
        ArrayList<String> records = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                for (int i = 1; i <= column_size; i++){
                    records.add(rs.getString(i));
                }                
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return records;
    }//getResults()
    
    public ArrayList <ArrayList<String>> getresults(String query){
        ArrayList <ArrayList<String>> records = new ArrayList<>();
        ArrayList <String>record = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int column_size = rsmd.getColumnCount();

            while (rs.next()){
                for (int i = 1; i <= column_size; i++){
                    record.add(rs.getString(i));
                }
                records.add(record);
                record = new ArrayList<>();
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return records;
    }//getResults()
    
    public int runquery(String query){
        try {
            stmt = conn.createStatement();
            if (stmt.execute(query) == true){
                rs = stmt.getResultSet();
            } else {
                return stmt.getUpdateCount();
            }            
            rs.close();
            stmt.close();
        } catch (SQLException ex){
            return -1;
        }
        return -1;
    }
}
