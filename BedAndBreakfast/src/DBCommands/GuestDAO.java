/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import classes.Guest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Aaron
 */
public class GuestDAO {
    
    private Statement stmt;
    private ResultSet rs;
    
    //connection
    DBConnection gc = new DBConnection();

    /**
     * Inserts new employee into database
     * @param guest     
     */
    public void insertGuest(Guest guest){
        //Gets Database Connection
        gc.getDBConnection();
        //Inserts Into Database to Create Guest Try Catch Block
        try{
            //Inserts Information into guests data table
            PreparedStatement insertGuest=gc.getConn()
                    .prepareStatement("INSERT INTO guests VALUES(?,?,?,?)");
            insertGuest.setString(1, guest.getGuestNumber());
            insertGuest.setString(2, guest.getLastName());
            insertGuest.setString(3, guest.getFirstName());
            insertGuest.setString(4, guest.getTitle());  
            
            //Inserts Information into addresses table
            PreparedStatement insertAddress=gc.getConn()
                    .prepareStatement("INSERT INTO addresses VALUES(?,?,?,?,?)");
            insertAddress.setString(1, guest.getGuestNumber());
            insertAddress.setString(2, guest.getStreet());
            insertAddress.setString(3, guest.getCity());
            insertAddress.setString(4, guest.getState());
            insertAddress.setString(5, guest.getZipCode());
            insertGuest.executeQuery();
            insertAddress.executeQuery();
            //Conformation Message
            showMessageDialog(null, "Guest Created");
            //Close DB Connection
            gc.getConn().close();
        }
        catch(SQLException ex){
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Searchs for Guest By guestNumber, first and last name, or street and zip code
    public ArrayList<Guest> searchGuest(String firstName,String lastName,
            String guestNumber,String street, String zipCode){
        
        //Creates the Guest List
        ArrayList<Guest> guestList=new ArrayList();
        //Creates the Database Connection
        gc.getDBConnection();
        
        //Database Search Statement
        String sql="SELECT * FROM GUESTS, ADDRESSES WHERE (GUESTS.GUEST_NO = ADDRESSES.GUEST_NO)"+
                    "AND (guests.guest_no = '"+guestNumber+"')"+ 
                    "OR (GUESTS.FIRST_NAME='"+firstName+"') AND (GUESTS.LAST_NAME='"+lastName+"')"+
                    "OR (ADDRESSES.STREET ='"+street+"') AND (ADDRESSES.ZIP='"+zipCode+"')";
        
        //Adds the Information to the Search ComboBox
        try{
            stmt=gc.getConn().createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                guestList.add(new Guest(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        }
        catch(SQLException ex){
            System.out.println("whoops"); //replace with a real exception
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Returns the List
        return guestList;       
    }   
}
