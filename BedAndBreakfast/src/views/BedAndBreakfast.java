/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DBCommands.GetConnection;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author prasasin
 */
public class BedAndBreakfast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World!");
        System.out.println("something else");
        System.out.println("New World by Aaron Coffman");
        

        //Examples of running queries
        GetConnection db1 = new GetConnection ("bbpms","bbpms","orcl","bbpms.ddns.net",1521);
        db1.getDBConnection();
        //Single column query 
        ArrayList result = db1.getresults("select rm_no from rooms",1);
        System.out.println(result);
        //multiple column query
        ArrayList <ArrayList<String>> results = db1.getresults("select * from rooms");
        System.out.println(results);
        System.out.println(results.get(1).get(0));
        
        
        RoomManagementModule rmManageModule = new RoomManagementModule();
        rmManageModule.pack();
        rmManageModule.setTitle("Employee Module");
        rmManageModule.setLocationRelativeTo(null);
        rmManageModule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rmManageModule.setVisible(true);
    }
    
}
