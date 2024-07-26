package com.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends javax.swing.JFrame {

    public Main(){
        initComponents();
    }

    private void initComponents() {

        setTitle("Vaps Clone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Üst kısım
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.setPreferredSize(new Dimension(800, 150));
        JLabel titleLabel = new JLabel("Data Display");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        topPanel.add(titleLabel, gbc);

        // Alt kısım
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(34, 45, 50));  // Koyu renk arka plan
        bottomPanel.setLayout(new GridLayout(2, 4, 10, 10));  // 2 satır, 4 sütun

        // Kategoriler
        String[] categories = {"Temperature", "Lighting", "Watering", "SoilAcidity", 
                               "All", "", "", ""};
        for (String category : categories) {
            JButton button = new JButton(category);
            button.setPreferredSize(new Dimension(150, 100));
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(60, 80, 100));
            button.setFocusPainted(false);
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (category.equals("Temperature")) { 
                        new Temperature().setVisible(true);
                    } else if(category.equals("Lighting")) {
                        new Lighting().setVisible(true);
                    }  else if (category.equals("Watering")){
                        new Watering().setVisible(true);
                    } else if (category.equals("SoilAcidity")) {
                        new SoilAcidity().setVisible(true);
                    } else if (category.equals("All")) {
                        new All().setVisible(true);
                    } else{
                         // Handle other categories if needed
                    }
                }
            });
            bottomPanel.add(button);
        }

        // Add panels to main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
    }
}


