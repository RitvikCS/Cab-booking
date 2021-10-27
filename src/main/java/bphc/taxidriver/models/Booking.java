package bphc.taxidriver.models;

import bphc.taxidriver.Main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class Booking {
    // Represents a booking
    private int bookingId;  // Will be auto-incremented when inserted into the db
    private Customer customer;
    private Driver driver;
    private int costOfBooking;
    private Location pickup;
    private Location dropoff;
    private boolean arrived;
   
    public static List<Booking> get() {//used to return element at a given index of array
        try {
            List<Booking> bookings = new ArrayList<Booking>();//creating booking array in db, getting customer and driver data
            List<Customer> customers = Customer.get();
            List<Driver> drivers = Driver.get();
            
            ResultSet rs = Main.manager.executeQuery("select * from booking;");//result set object created(rs contains a row that satisfies the condition)
            while (rs.next()) {//this statement is true until the end of file is reached
                Booking booking = new Booking();//creating a new booking
                
                booking.setBookingId(rs.getInt("bookingId"));//setting a booking ID
                
                String customer_username = rs.getString("customer");//getting data
                booking.setCustomer(customers.stream().filter(
                        c -> c.getUsername().compareTo(customer_username) == 0//comparing data of customer with that already in db
                ).findFirst().get());
                
                String driver_username = rs.getString("driver");
                booking.setDriver(drivers.stream().filter(
                        d -> d.getUsername().compareTo(driver_username) == 0//comparing data of driver with that already in db
                ).findFirst().get());
                
                booking.setCostOfBooking(rs.getInt("costOfBooking"));//giving values to respective fields
                booking.setPickupLocation(rs.getInt("pickup"));
                booking.setDropoffLocation(rs.getInt("dropoff"));
                booking.setCostOfBooking(rs.getInt("costOfBooking"));
                booking.setArrived(rs.getInt("arrived") != 0);
                
                bookings.add(booking);//booking added
            }
            
            return bookings;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainFrame, "Error while fetching Booking objects", "ERROR",
                                          JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean save() {
        // Check if we need to insert or update
        try {
            ResultSet rs = Main.manager.executeQuery(String.format("select * from booking where bookingid='$%d';",
                                                                   this.bookingId));
            if (rs.next()){
                // update
                Main.manager.executeUpdate(String.format("update booking set customer='%s', driver='%s'," +
                                                        "costOfBooking='%d', pickup='%d', dropff='%d', arrived='%d' " +
                                                        "where bookingid='%d';",
                                                        this.customer.username, this.driver.username, 
                                                        this.costOfBooking, this.pickup.getIndex(),
                                                        this.dropoff.getIndex(), this.arrived ? 1 : 0, this.bookingId));
            } else {
                // insert 
               Main.manager.executeUpdate(String.format("insert into booking (customer, driver, costOfBooking, " +
                                                        "pickup, dropoff, arrived)  values('%s', '%s', '%d', '%d',"+
                                                        "'%d', '%d');", this.customer.username, this.driver.username, 
                                                        this.costOfBooking, this.pickup.getIndex(),
                                                        this.dropoff.getIndex(), this.arrived ? 1 : 0));
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainFrame, "Error while saving Booking object", "ERROR",
                                          JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
    
     public int getBookingId() {
        return bookingId;
    }
    
    private void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer c) {
        this.customer = c;
    }
    
    public Driver getDriver() {
        return driver;
    }
    
    public void setDriver(Driver d) {
        this.driver = d;
    }
    
    public int getCostOfBooking() {
        return costOfBooking;
    }
    
    public void setCostOfBooking(int cost) {
        this.costOfBooking = cost;
    }
    
    public Location getPickupLocation() {
        return pickup;
    }
    
    public void setPickupLocation(Location loc) {
        this.pickup = loc;
    }
    
    public void setPickupLocation(int loc) {
        this.pickup = Arrays.stream(Location.values()).filter(s -> s.getIndex() == loc).findFirst().get();
    }
    
    public Location getDropOffLocation() {
        return dropoff;
    }
    
    public void setDropoffLocation(Location loc) {
        this.dropoff = loc;
    }
    
    public void setDropoffLocation(int loc) {
        this.dropoff = Arrays.stream(Location.values()).filter(s -> s.getIndex() == loc).findFirst().get();
    }
    
    public boolean getArrived() {
        return this.arrived;
    }
    
    public void setArrived(boolean val) {
        this.arrived = val;
    }
}
