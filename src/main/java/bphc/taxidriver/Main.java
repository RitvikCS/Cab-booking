package bphc.taxidriver;

import bphc.taxidriver.models.Customer;
import bphc.taxidriver.ui.CurrentBooking;
import bphc.taxidriver.ui.Frame;
import bphc.taxidriver.ui.Login;
import bphc.taxidriver.ui.MakeBooking;
import bphc.taxidriver.ui.Register;
import javax.swing.JOptionPane;

public class Main {
    public static Frame mainFrame;
    public static Login loginPanel;
    public static Register registerPanel;
    public static MakeBooking makeBookingPanel;
    public static CurrentBooking currentBookingPanel;
    public static Customer currentCustomer;
    public static DatabaseManager manager;
    
    public static void main(String args[]) { 
        mainFrame = new Frame();//instantiation of all main pages
        loginPanel = new Login();
        registerPanel = new Register();
        makeBookingPanel = new MakeBooking();
        currentBookingPanel = new CurrentBooking();
        mainFrame.addCard(loginPanel, "login");//connecting frames
        mainFrame.addCard(registerPanel, "register");
        mainFrame.addCard(makeBookingPanel, "makeBooking");
        mainFrame.addCard(currentBookingPanel, "currentBooking");
        
        mainFrame.showCard("login");
        
        try {//connecting database to app
            manager = DatabaseManager.createConnection("data.db");
        } catch (Exception e) { // Fatal error if data base connection fails 
                JOptionPane.showMessageDialog(null, "Error while creating connection to database.", "FATAL ERROR", 
                                              JOptionPane.ERROR);// catching sql error
                e.printStackTrace();
                System.exit(0);
         }
        
        /* Default code created by NetBeans */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainFrame.setVisible(true);
            }
        });
    }
}
