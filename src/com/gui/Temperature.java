package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temperature extends javax.swing.JFrame {
    
    public Temperature(){
        initComponents();
    }

    private void initComponents(){
        setTitle("Temperature");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Number of dashes
        int numberOfDashes = 10; // You can change this to add more or fewer dashes

        for (int i = 0; i < numberOfDashes; i++) {
            JLabel dashLabel = new JLabel("—");
            dashLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            dashLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(dashLabel);
        }

        // Add main panel to frame
        getContentPane().add(mainPanel);

        setVisible(true);
    }
}
