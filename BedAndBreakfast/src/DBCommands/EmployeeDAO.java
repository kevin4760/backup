/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import classes.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Kevin
 */
public class EmployeeDAO {
    
    //variables
    private Statement stmt;
    private ResultSet rs;
    
    //final variables
    private final String dbTable = "employees";


    //connection
    GetConnection gc = new GetConnection();
    
    //create employee
    /**
     * 
     * @param firstName
     * @param lastName
     * @param employeeID
     * @param userName
     * @param password
     * @return 
     */
    public Employee createEmployee(String firstName, String lastName, String employeeID, String userName, String password) {
        return new Employee(firstName, lastName, employeeID, userName, password);
    }
    
    //insert employee
    public void insertEmployee(Employee employee) throws SQLException {
        gc.getDBConnection();
        PreparedStatement insertRecord = gc.getConn().prepareStatement
            ("INSERT INTO employees VALUES(?, ?, ?, ?, ?, ?)");
        insertRecord.setString(1, employee.getEmployeeID());
        insertRecord.setString(2, employee.getHotelID());
        insertRecord.setString(3, employee.getLastName());
        insertRecord.setString(4, employee.getFirstName());
        insertRecord.setString(5, employee.getUserName());
        insertRecord.setString(6, employee.getPassword());
        insertRecord.execute();
    }
   
    //search function
    public void searchEmp(String firstName, String lastName, String employeeID, String userName, String hotelID) {
        String search = null;
        //SELECT * FROM EMPLOYEES WHERE (emp_id = ?)
        //check if name is empty, search empid, then check username
        gc.getDBConnection();
        
        String sql = "SELECT * FROM EMPLOYEES WHERE (emp_id = '"+ employeeID +"') OR "
                + "(last_name = '" + lastName + "' AND first_name = '"+ firstName+"') OR "
                + "(user_name ='"+userName+"') OR "
                + "(hotel_id ='"+hotelID+"')";
        try {
            stmt = gc.getConn().createStatement();
            rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
//            System.out.println(rs.next()); //testing line delete
            while(rs.next()) {
                for (int i =1; i<= columns; i++){
                    System.out.print(rs.getString(i)+" ");
                }
                System.out.println();
            }
                
        } catch(SQLException ex) {
            System.out.println("whoops"); //replace with a real exception
        }
        System.out.println("didn't crash"); //testing line delet
    }
    
}
