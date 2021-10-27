package bphc.taxidriver.ui;

import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JPanel;

public class Frame extends javax.swing.JFrame {
    
    HashMap<String, JPanel> cards = new HashMap<>();
    String curCard = "";
    
    public Frame() {
        initComponents();
    }
    
    public void showCard(String name) {
        curCard = name;
        
        CardLayout layout = (CardLayout) this.getContentPane().getLayout();
        layout.show(this.getContentPane(), name);
        
        this.getContentPane().setPreferredSize(cards.get(name).getPreferredSize());
        this.pack();
    }
    
    public void addCard(JPanel card, String name) {
        cards.put(name, card);
        this.getContentPane().add(card, name);
        if (curCard.isEmpty()){
            curCard = name;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
