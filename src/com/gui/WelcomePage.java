package com.gui;

import java.awt.*;
import javax.swing.*;

public class WelcomePage extends javax.swing.JFrame{

    private javax.swing.JButton btnNext;

    public WelcomePage() {
        initComponents();
    }

    private void initComponents(){
        
        setTitle("Vaps Clone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a label for the app name
        JLabel appNameLabel = new JLabel("Vaps Clone", SwingConstants.CENTER);
        appNameLabel.setFont(new Font("Arial", Font.BOLD, 40));

        // Add the app name label to the center of the main panel
        mainPanel.add(appNameLabel, BorderLayout.CENTER);

        // Create a button to navigate to another page
        btnNext = new javax.swing.JButton();

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 14));
        btnNext.setText("Continue");

        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        // Add the button to the bottom of the main panel
        mainPanel.add(btnNext, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        // Open the main frame
        new Main().setVisible(true);
        System.out.println("main loaded");
        // Close the login frame
        this.dispose();
    }

    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WelcomePage wp = new WelcomePage();
                wp.setVisible(true);
                
            }
        });
    }
}
