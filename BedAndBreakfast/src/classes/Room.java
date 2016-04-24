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
public class Room {
    
    private String rmNO;
    private double useCount;
    private int beds;
    private String hotelID;
    private int clean;

    public Room() {
        //empty
    }
    public Room(String rmNo, double useCount, int beds, String hotelID, int clean) {
        this.rmNO = rmNo;
        this.useCount = useCount;
        this.beds = beds;
        this.hotelID = hotelID;
        this.clean = clean;
    }
    //create room for rollover
    public Room(String rmNo, double useCount){
        this.rmNO = rmNo;
        this.useCount = useCount;
    }

    /**
     * @return the rmNO
     */
    public String getRmNO() {
        return rmNO;
    }

    /**
     * @param rmNO the rmNO to set
     */
    public void setRmNO(String rmNO) {
        this.rmNO = rmNO;
    }

    /**
     * @return the useCount
     */
    public double getUseCount() {
        return useCount;
    }

    /**
     * @param useCount the useCount to set
     */
    public void setUseCount(double useCount) {
        this.useCount = useCount;
    }

    /**
     * @return the beds
     */
    public int getBeds() {
        return beds;
    }

    /**
     * @param beds the beds to set
     */
    public void setBeds(int beds) {
        this.beds = beds;
    }

    /**
     * @return the hotelID
     */
    public String getHotelID() {
        return hotelID;
    }

    /**
     * @param hotelID the hotelID to set
     */
    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    /**
     * @return the clean
     */
    public int getClean() {
        return clean;
    }

    /**
     * @param clean the clean to set
     */
    public void setClean(int clean) {
        this.clean = clean;
    }
}
