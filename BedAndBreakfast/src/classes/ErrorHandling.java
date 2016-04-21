/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * ErrorHandling.java
 * @author Greg
 * class that SQL exceptions, other exceptions, and other errors
 * and handles it gracefully spitting out an appropriate error message
 */
public class ErrorHandling {
    
    //constructor
    public ErrorHandling(){
        
    }
    
    //WORK IN PROGRESS- method that takes the SQL exception being thrown and gives an error for it.
    public void displayException(SQLException ex, String messageString){        
        showMessageDialog(null, messageString, "Error", JOptionPane.ERROR_MESSAGE);        
    }
    
    //WORK IN PROGRESS- method that takes the SQL exception being thrown and just gives the generic SQL exception message for it.
    public void displayException(SQLException ex){
        showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       
    }
    
    //WORK IN PROGRESS- method that takes the exception being thrown and gives an error for it.
    public void displayException(Exception ex, String messageString){        
        showMessageDialog(null, messageString, "Error", JOptionPane.ERROR_MESSAGE);        
    }
    
    //WORK IN PROGRESS- method that takes the exception being thrown and just gives the generic exception message for it.
    public void displayException(Exception ex){
        showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       
    }
}
