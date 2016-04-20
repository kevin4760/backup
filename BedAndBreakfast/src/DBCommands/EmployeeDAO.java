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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

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
    DBConnection gc = new DBConnection();
    
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
//    public Employee createEmployee(String firstName, String lastName, String employeeID, String userName, String password) {
//        return new Employee(firstName, lastName, employeeID, userName, password);
//    }

    //insert employee
    /**
     * Inserts new employee into database
     * @param employee 
     */
    public void insertEmployee(Employee employee) {
        gc.getDBConnection();
        try {
            PreparedStatement insertRecord = gc.getConn().prepareStatement
                ("INSERT INTO employees VALUES(?, ?, ?, ?, ?, ?)");
            insertRecord.setString(1, employee.getEmployeeID());
            insertRecord.setString(2, employee.getHotelID());
            insertRecord.setString(3, employee.getLastName());
            insertRecord.setString(4, employee.getFirstName());
            insertRecord.setString(5, employee.getUserName());
            insertRecord.setString(6, employee.getPassword());
            insertRecord.execute();
            gc.getConn().close();
        } catch(SQLException ex) {
            
        }
    }
   
    //search function -> used to add list to jlist
    /**
     * 
     * @param firstName
     * @param lastName
     * @param employeeID
     * @param userName
     * @param hotelID
     * @return arraylist of Employees
     */
    public ArrayList<Employee> searchEmp(String firstName, String lastName, String employeeID, String userName, String hotelID) {
        //create the arraylist
        ArrayList<Employee> empList = new ArrayList();
        //connect to db
        gc.getDBConnection();
        //search string that uses all possible fields other than password
        String sql = "SELECT * FROM EMPLOYEES WHERE (emp_id = '"+ employeeID +"') OR "
                + "(last_name = '" + lastName + "' AND first_name = '"+ firstName+"') OR "
                + "(user_name ='"+userName+"') OR "
                + "(hotel_id ='"+hotelID+"')";
        //get info from DB
        try {
            stmt = gc.getConn().createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                empList.add(new Employee(rs.getString(4),rs.getString(3),rs.getString(1),rs.getString(5),rs.getString(6)));
            }//end while
        } catch(SQLException ex) {
            System.out.println("whoops"); //replace with a real exception
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        //TESTING ITEM ITERATE THROUGH LIST
//        for(int i=0; i<empList.size(); i++){
//            System.out.println("while: " + empList.get(i));
//        }//TESTING ITEM END
        return empList;
    }
    
//    //Update Employee
//    public void updateEmployee () {
//        gc.getDBConnection();
//        try {
//            PreparedStatement insertRecord = gc.getConn().prepareStatement
//                ("UPDATE employees SET e");
//            insertRecord.setString(1, employee.getEmployeeID());
//            insertRecord.setString(2, employee.getHotelID());
//            insertRecord.setString(3, employee.getLastName());
//            insertRecord.setString(4, employee.getFirstName());
//            insertRecord.setString(5, employee.getUserName());
//            insertRecord.setString(6, employee.getPassword());
//            insertRecord.execute();
//        } catch(SQLException ex) {
//            
//        }
//    }
    
}
