/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import classes.Reservation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *is used to facilitate between reservation form and database
 * @author Kevin
 */
public class ReservationDAO {
    //variables
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    
    //connection
    DBConnection gc = new DBConnection();
    
    //insert reservation -> ReservationPage.book
    public void insertReservation(Reservation r) {
        //connects to database
        gc.getDBConnection();
        //need method to get guest and room number
        try{
            //creates unique reservation number sets to current reservation
            r.setResNo(gc.uniqueID("reservations", "1"));
            //insert record
            ps=gc.getConn().prepareStatement
                ("INSERT INTO reservations VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, r.getResNo());
            ps.setString(2, r.getRoomNumber());
            ps.setString(3, r.getGuestNumber());
            ps.setString(4, r.getCheckIn());
            ps.setString(5, r.getCheckOut());
            ps.setDouble(6, r.getPrice());
            ps.setInt(7, r.getStatus());
            ps.executeQuery();
            //user message
            showMessageDialog(null, "Reservation Created: " + r.getResNo(), "Record Added", JOptionPane.INFORMATION_MESSAGE);
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end insertReservation()
    
    //creates SQL date format to be used in insertReservation()
}
