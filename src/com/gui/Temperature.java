package com.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

public class Temperature extends javax.swing.JFrame {

    private JSlider slider;
    private JLabel tempLabel;
    JPanel mainPanel;

    public Temperature(){
        initComponents();
    }

    private void initComponents(){
        setTitle("Temperature");
        setSize(400, 300);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new GridLayout(1,2));

        tempLabel = new JLabel("25.0", JLabel.CENTER);
        tempLabel.setFont(new Font("Serif", Font.BOLD, 48));
        tempLabel.setOpaque(true);

        // Slider
        slider = new JSlider(JSlider.VERTICAL, 200, 500, 250); 
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double temp = slider.getValue() / 10.0;
                tempLabel.setText(String.valueOf(temp));
                //updateLabelColor(temp);
                //colorPanel.repaint();
            }
        });

        JPanel dashPanel = new JPanel(); //dashler alt alta olsun diye yeni center alignment yapcam
        dashPanel.setLayout(new BoxLayout(dashPanel, BoxLayout.Y_AXIS));
        
        // Number of dashes
        int numberOfDashes = 10 * 5; // You can change this to add more or fewer dashes

        for (int i = numberOfDashes; i >= 20; i-=3) {
            JLabel dashLabel = new JLabel("—  " + i);
            dashLabel.setFont(new Font("Serif", Font.PLAIN, 18));
            dashLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally
            dashPanel.add(dashLabel);
        }

        //mainPanel.add(whiteDashPanel, BorderLayout.WEST);
        mainPanel.add(tempLabel, BorderLayout.SOUTH);
        mainPanel.add(slider, BorderLayout.CENTER);
        mainPanel.add(dashPanel, BorderLayout.CENTER);

        // Add main panel to frame
        getContentPane().add(mainPanel);

        setVisible(true);
    }

    public JPanel getJPanel(){
        return mainPanel;
    }
}
