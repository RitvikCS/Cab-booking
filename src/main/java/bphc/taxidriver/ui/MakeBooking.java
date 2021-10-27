package bphc.taxidriver.ui;

import bphc.taxidriver.Main;
import bphc.taxidriver.models.Booking;
import bphc.taxidriver.models.Driver;
import bphc.taxidriver.models.Location;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class MakeBooking extends javax.swing.JPanel {

    public MakeBooking() {
        initComponents();
        
        String[] model =  Arrays.stream(Location.values()).map(s -> s.toString()).toArray(String[]::new);
        cmbPickup.setModel(new DefaultComboBoxModel<>(model));
        cmbDropOff.setModel(new DefaultComboBoxModel<>(model));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbPickup = new javax.swing.JComboBox<>();
        cmbDropOff = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        btnBook = new javax.swing.JButton();
        btnTopup = new javax.swing.JButton();
        lblCost = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TAXI BOOKING");

        jLabel1.setText("Pick Up Location: ");

        cmbPickup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPickup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPickupActionPerformed(evt);
            }
        });

        cmbDropOff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDropOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDropOffActionPerformed(evt);
            }
        });

        jLabel2.setText("Drop off Location: ");

        lblBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBalance.setText("Wallet Balance: ₹100");

        btnBook.setText("Book Cab");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnTopup.setText("Topup");
        btnTopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopupActionPerformed(evt);
            }
        });

        lblCost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCost.setText("Cost of booking: ₹100");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPickup, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbDropOff, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTopup)
                                .addGap(44, 44, 44)
                                .addComponent(btnBook)))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(64, Short.MAX_VALUE)
                    .addComponent(lblCost, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbPickup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbDropOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(lblBalance)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBook)
                    .addComponent(btnTopup))
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(124, Short.MAX_VALUE)
                    .addComponent(lblCost)
                    .addContainerGap(125, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        
        // Make sure we have enough cash
        if (Main.currentCustomer.getBalance() < 300) {
            JOptionPane.showMessageDialog(null, "You do not have enough money in your wallet. Please topup.");
            return;
        }
        
        Booking booking = new Booking();
        
        if (cmbPickup.getSelectedIndex() == cmbDropOff.getSelectedIndex()) {
            JOptionPane.showMessageDialog(null, "Pickup and dropoff location can't be the same");
            return;
        }
        
        Location pickupLoc = Location.fromIndex(cmbPickup.getSelectedIndex());
        Location dropOffLoc = Location.fromIndex(cmbDropOff.getSelectedIndex());
        Driver driver = findOptimalDriver(pickupLoc);
        int cost = calculateCost(); 
        
        if (driver == null) {
            JOptionPane.showMessageDialog(null, "Could not find a cab. Please try again later");
            return;
        }
        
        booking.setCustomer(Main.currentCustomer);
        booking.setDriver(driver);
        booking.setPickupLocation(pickupLoc);
        booking.setDropoffLocation(dropOffLoc);
        booking.setArrived(false);
        booking.setCostOfBooking(cost);
        
        driver.setBooked(true);
        Main.currentCustomer.spendAmount(cost);
        
        booking.save(); 
        driver.save();
        Main.currentCustomer.save();
        
        Main.currentBookingPanel.setBooking(booking);
        Main.mainFrame.showCard("currentBooking");
    }//GEN-LAST:event_btnBookActionPerformed

    private void cmbPickupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPickupActionPerformed
         updateCost();
    }//GEN-LAST:event_cmbPickupActionPerformed

    private void cmbDropOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDropOffActionPerformed
        updateCost();
    }//GEN-LAST:event_cmbDropOffActionPerformed

    private void btnTopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopupActionPerformed
        String val = JOptionPane.showInputDialog(null, "Enter how much money you'd like to add to your wallet: ");
        try {
            int topup = Integer.parseInt(val);
            if (JOptionPane.showConfirmDialog(null, "Go ahead and add " + val + " to your wallet?") == 0) {
                Main.currentCustomer.setBalance(Main.currentCustomer.getBalance() + topup);
                Main.currentCustomer.save();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error while parsing input. Make sure you've entered a valid number.");
        }
        this.lblBalance.setText("Wallet Balance: ₹" + Main.currentCustomer.getBalance());
    }//GEN-LAST:event_btnTopupActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       this.lblBalance.setText("Wallet Balance: ₹" + Main.currentCustomer.getBalance());
       updateCost();
    }//GEN-LAST:event_formComponentShown

    private Driver findOptimalDriver(Location pickup) {
        List<Driver> drivers = Driver.get();
        drivers.sort((a, b) -> {  // Sort by rating followed by nearest drivers
            int diff = a.getRating() - b.getRating();
            if (diff == 0) {
                diff = a.getCurrentLocation().getIndex() - pickup.getIndex();
                return diff > 0 ? diff : -1 * diff;
            } else {
                return diff;
            }
        });
        
        for (Driver d : drivers) {
            if (!d.isBooked()) {
                return d;
            }
        }
        
        return null;
    }
    
    private int calculateCost() {
        int diff = cmbPickup.getSelectedIndex() - cmbDropOff.getSelectedIndex();
        diff = diff > 0 ? diff : -1 * diff;
        return diff * 100;
    }
    
    private void updateCost() {
        int cost = calculateCost();
        lblCost.setText("Cost of booking: ₹" + cost);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnTopup;
    private javax.swing.JComboBox<String> cmbDropOff;
    private javax.swing.JComboBox<String> cmbPickup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCost;
    // End of variables declaration//GEN-END:variables
}
