/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Aaron
 */
public class Guest{
    
    //initialize values
    private String firstName;
    private String lastName;
    private String title;
    private String street;
    private String city;
    private String state;
    private String zipCode;    
    private String guestNumber;
      
    //constructors
    public Guest() {
        //empty
    }
    
    //Constructors
    public Guest(String guestNumber, String lastName, String firstName, String title, 
            String street, String city, String state, String zipCode){
        this.firstName=firstName;
        this.lastName=lastName;
        this.title=title;
        this.street=street;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;
        this.guestNumber=guestNumber;                      
    }
     
    public String getFirstName() {
        return firstName;
    }
  
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
   
    public String getLastName() {
        return lastName;
    }
   
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title=title;
    }
    
    public String getStreet(){
        return street;
    }
    
    public void setStreet(String street){
        this.street=street;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city=city;
    }
    
    public String getState(){
        return state;
    }   
    
    public void setState(String state){
        this.state=state;        
    }
    
    public String getZipCode(){
        return zipCode;    
    }
    
    public void setZipCode(String zipCode){
        this.zipCode=zipCode;
    }

    public String getGuestNumber(){
        return guestNumber;
    }
    
    public void setGuestNumber(String guestNumber){
        this.guestNumber=guestNumber;
    }     
}
