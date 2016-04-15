/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DBCommands.GetConnection;
import java.util.*;

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
        ArrayList results = db1.getresults("select rm_no from rooms",1);
        System.out.println(results);
        //multiple column query
        ArrayList <ArrayList<String>> result = db1.getresults("select * from rooms");
        System.out.println(result);
        System.out.println(result.get(1).get(0));
    }
    
}
