/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Kevin
 */
public class Employee {
    
    //initialize values
    private String firstName;
    private String lastName;
    private String employeeID;
    private String userName;
    private String password;
    private String hotelID;
    
    //constructors
    public Employee() {
        //empty
    }
    
    public Employee(Employee employee) {
        
    }
    
    public Employee(String firstName, String lastName, String employeeID, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.userName = userName;
        this.password = password;
        this.hotelID = "001";
    }
    //end constructors

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the hotelID
     */
    public String getHotelID() {
        return hotelID;
    }
    /**
     * @param hotelID 
     */
    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }
    
}
