package bphc.taxidriver.models;

import bphc.taxidriver.Main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * All Drivers are sub-classes of User. Even though they may not be able to
 * login, they would still have a first name, last name etc. Further, this
 * model of allows for creating a login system for Drivers easily
 */
public class Driver extends User {
    private Location currentLocation;
    private int numberOfBookings;
    private int rating; // 0-10 rating system
    private boolean booked; 
   
    public static List<Driver> get() {
        try {
            List<Driver> drivers = new ArrayList<>();
            ResultSet rs = Main.manager.executeQuery(String.format("select * from driver;"));
            
            while (rs.next()) {
                Driver driver = new Driver();
                driver.setUsername(rs.getString("username"));
                driver.setPassword(rs.getString("password"));
                driver.setFirstName(rs.getString("firstName"));
                driver.setLastName(rs.getString("lastName"));
                driver.setEmailID(rs.getString("emailID"));
                driver.setPhNumber(rs.getString("phNumber"));
                driver.setCurrentLocation(rs.getInt("currentLocation"));
                driver.setRating(rs.getInt("rating"));
                driver.setBooked(rs.getInt("booked") != 0);
                driver.setNumberOfBookings(rs.getInt("numberOfBookings"));
                
                drivers.add(driver);
            }
            
            return drivers;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainFrame, "Error while retrieving", "ERROR",
                                          JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean save() {
        // Check if we need to insert or update
        try {
            ResultSet rs = Main.manager.executeQuery(String.format("select * from driver where username='%s';",
                                                                   this.username));
            if (rs.next()){
                // update
                Main.manager.executeUpdate(String.format("update driver set username='%s', password='%s'," +
                                                         "firstName='%s',lastName='%s', emailID='%s', phNumber='%s', currentLocation='%s', " + 
                                                         "rating='%d', booked='%d', numberOfBookings='%d' where username='%s';",
                                                         this.username, this.password, this.firstName, this.lastName, 
                                                         this.emailID, this.phNumber, this.currentLocation.getIndex(),
                                                         this.getRating(), this.isBooked() ? 1 : 0, this.numberOfBookings, this.username));
            } else {
                // insert 
               Main.manager.executeUpdate(String.format("insert into customer (%s, %s, %s, %s, %s, %s, %d, %,d, %d, %d);",
                                                        this.username, this.password, this.firstName, this.lastName,
                                                        this.emailID, this.phNumber, this.currentLocation.getIndex(), 
                                                        this.getRating(), this.isBooked() ? 1 : 0, this.numberOfBookings));
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainFrame, "Error while saving Driver object", "ERROR",
                                          JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
        
    }
    
    public void rate(int rating) {
        this.rating = ((this.rating * this.numberOfBookings) + rating) / (this.numberOfBookings + 1);
        this.numberOfBookings += 1;
    }
    
    public Location getCurrentLocation() {
        return currentLocation;
    }
    
    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }
    
    public void setCurrentLocation(int index) {
        setCurrentLocation(Location.fromIndex(index));
    }
    
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    
    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(int numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }
}
