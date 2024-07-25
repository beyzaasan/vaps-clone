package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;

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
        mainPanel.setLayout(new BorderLayout());

        JLabel whiteDash = new JLabel("|");
        // Set the font size and color
        whiteDash.setFont(new Font("Arial", Font.BOLD, 200)); // Adjust size as needed
        whiteDash.setForeground(Color.WHITE);
        whiteDash.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(whiteDash, BorderLayout.WEST);

        JPanel dashPanel = new JPanel();
        dashPanel.setLayout(new BoxLayout(dashPanel, BoxLayout.Y_AXIS));
        
        // Number of dashes
        int numberOfDashes = 10; // You can change this to add more or fewer dashes

        for (int i = 0; i < numberOfDashes; i++) {
            JLabel dashLabel = new JLabel("—  ");
            dashLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            dashLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally
            dashPanel.add(dashLabel);
        }

        mainPanel.add(dashPanel, BorderLayout.EAST);

        // Add main panel to frame
        getContentPane().add(mainPanel);

        setVisible(true);
    }
}
