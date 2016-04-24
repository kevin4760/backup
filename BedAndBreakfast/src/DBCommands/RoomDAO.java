/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import classes.Room;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kevin
 */
public class RoomDAO {
    Room room = new Room();
    DBConnection gc = new DBConnection();
    
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    
    
    //when you hit this button it adds 1 to the weight of all checked in rooms
    //this is why it should be run at 3am when most rooms will be checked in
    public void updateUse() {
        gc.getDBConnection();
        ArrayList<Room> rList = new ArrayList<>();
        //reservation status 1 means checked in
        //sql string breakdown, select all rooms from reservations and rooms where reservations are checked in
        String sql = "SELECT * FROM reservations, rooms WHERE reservations.rm_no = rooms.rm_no AND reservations.status = 1";
        try {
            //connect DB
            stmt = gc.getConn().createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                rList.add(new Room(rs.getString(2), rs.getDouble(8)));
            }//end while-> all checked in rooms are now in the ArrayList
        
            //updates room
            ps = gc.getConn().prepareCall("UPDATE rooms SET use_count = use_count + 1 WHERE rm_no=?");
            for (Room rList1 : rList) {
                //insert and run ps
                ps.setString(1, rList1.getRmNO());
                System.out.print(rList1.getRmNO());
                ps.executeQuery();
            }
            gc.getConn().close();
        }catch(SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
