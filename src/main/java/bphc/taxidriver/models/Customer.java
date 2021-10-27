package bphc.taxidriver.models;

import bphc.taxidriver.Main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Customer extends User{
    private int balance = 0; // Set the default value
    
    public void spendAmount(int balance) {
        if (this.balance < 300) {
            throw new IllegalStateException("Wallet balance is less than 300. Please top-up before spending any money");
        }
        
        this.balance -= balance;
    }

    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
   
    public static List<Customer> get() {
        try {
            List<Customer> customers = new ArrayList<>();
            ResultSet rs = Main.manager.executeQuery(String.format("select * from customer;"));
            
            while (rs.next()) {//registeration
                Customer customer = new Customer();
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setEmailID(rs.getString("emailID"));
                customer.setPhNumber(rs.getString("phNumber"));
                customer.setBalance(rs.getInt("balance"));
                customers.add(customer);
            }
            
            return customers;
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
            ResultSet rs = Main.manager.executeQuery(String.format("select * from customer where username='%s';",
                                                                   this.username));
            if (rs.next()){
                // update
                Main.manager.executeUpdate(String.format("update customer set username='%s', password='%s'," +
                                                        "firstName='%s',lastName='%s', emailID='%s', phNumber='%s'," + 
                                                        "balance='%d' where username='%s';", this.username, 
                                                        this.password, this.firstName, this.lastName, this.emailID, 
                                                        this.phNumber, this.balance, this.username));
            } else {
                // insert 
               Main.manager.executeUpdate(String.format("insert into customer values('%s', '%s', '%s', '%s', '%s', '%s', '%d');",
                                                        this.username, this.password, this.firstName, this.lastName,
                                                        this.emailID, this.phNumber, this.balance));
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainFrame, "Error while saving Customer object", "ERROR",
                                          JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
}
