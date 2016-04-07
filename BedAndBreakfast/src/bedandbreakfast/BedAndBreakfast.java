/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast;

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
        GetConnection db1 = new GetConnection ("opera","opera","opera","ssut",1521);
        db1.getDBConnection();
        ArrayList results = db1.runquery("select * from resort where resort = 'MID'", 5);
        System.out.println(results);
    }
    
}
