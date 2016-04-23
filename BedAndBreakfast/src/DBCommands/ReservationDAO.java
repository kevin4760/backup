/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import classes.Reservation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import views.GuestSearchModule;

/**
 *is used to facilitate between reservation form and database
 * @author Kevin
 */
/*
status can be the following
0 - reserved
1 - check in
2 - check out
3 - cancel
4 - no show
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
            //catches violation of unique guest_id
            if (ex.getSQLState().startsWith("23")){
                //creates user options and throw to GuestSearchModule for guest creation
                int reply = JOptionPane.showConfirmDialog(null, "Guest does not exist.  "
                    + "Would you like to create Guest?", "Invalid Guest Number", JOptionPane.YES_NO_OPTION);
                if (reply == 0) {
                    new GuestSearchModule().setVisible(true);
                }
            }
        }
    }//end insertReservation()
    
    //check in reservaton
    public void checkInReservation(Reservation r) {
        //connects to database
        gc.getDBConnection();
        try{
            ps=gc.getConn().prepareStatement
                ("UPDATE reservations SET status=? where res_no=?");
            ps.setInt(1, 1);
            ps.setString(2, r.getResNo());
            ps.executeQuery();
            //user message
            showMessageDialog(null, "Reservation Checked In", "Checked In", JOptionPane.INFORMATION_MESSAGE);
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end checkinReservation()
    
    //check out reservaton
    public void checkOutReservation(Reservation r) {
        //connects to database
        gc.getDBConnection();
        try{
            ps=gc.getConn().prepareStatement
                ("UPDATE reservations SET status=? where res_no=?");
            ps.setInt(1, 2);
            ps.setString(2, r.getResNo());
            ps.executeQuery();
            //user message
            showMessageDialog(null, "Reservation Checked In", "Checked In", JOptionPane.INFORMATION_MESSAGE);
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end checkOutReservation()
    
    //cancel reservaton
    public void cancelReservation(Reservation r) {
        //connects to database
        gc.getDBConnection();
        try{
            ps=gc.getConn().prepareStatement
                ("UPDATE reservations SET status=? where res_no=?");
            ps.setInt(1, 3);
            ps.setString(2, r.getResNo());
            ps.executeQuery();
            //user message
            showMessageDialog(null, "Reservation Checked In", "Checked In", JOptionPane.INFORMATION_MESSAGE);
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end cancelReservation()
    //no show reservaton
    public void noShowReservation(Reservation r) {
        //connects to database
        gc.getDBConnection();
        try{
            ps=gc.getConn().prepareStatement
                ("UPDATE reservations SET status=? where res_no=?");
            ps.setInt(1, 4);
            ps.setString(2, r.getResNo());
            ps.executeQuery();
            //user message
            showMessageDialog(null, "Reservation Checked In", "Checked In", JOptionPane.INFORMATION_MESSAGE);
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end noShowReservation()
    //Search reservaton
    public ArrayList<Reservation> searchReservationByResNo(int res_no) {
        //connects to database
        gc.getDBConnection();
        ArrayList <Reservation>records = new ArrayList<>();
        //need method to get guest and room number
        try{
            ps=gc.getConn().prepareStatement
                ("select res_no, rm_no, guest_no, in_date, out_date, price"
                        + ",status from reservations where res_no=?");
            ps.setInt(1, res_no);
            rs = ps.executeQuery();
            while (rs.next()){
                records.add(new Reservation(rs.getString(1), rs.getString(2),
                rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6)));
            }
            rs.close();
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return records;
    }//end searchReservation()
}
