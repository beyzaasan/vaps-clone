package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class WelcomePage extends javax.swing.JFrame {

    private javax.swing.JButton btnNext;

    public WelcomePage() {
        initComponents();
    }

    private void initComponents() {

        setTitle("Vaps Clone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240)); // Açık gri arka plan

        // Create a logo or graphic if available
        JLabel logoLabel = new JLabel();
        try {
            BufferedImage bufferedImage = ImageIO.read(getClass().getResourceAsStream("../../images/pace.png"));
            ImageIcon logoIcon = new ImageIcon(bufferedImage);
            logoLabel.setIcon(logoIcon);
        } catch (IOException e) {
            e.printStackTrace(); // Print error if image not found
            logoLabel.setText("Logo not found");
            logoLabel.setForeground(new Color(0, 77, 0)); // Koyu yeşil metin
        }
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setOpaque(true);
        logoLabel.setBackground(new Color(208, 208, 208)); // Arka plan rengiyle eşleşen renk
        logoLabel.setForeground(new Color(0, 77, 0)); // Koyu yeşil metin
        mainPanel.add(logoLabel, BorderLayout.NORTH);

        // Create a label for the app name
        JLabel appNameLabel = new JLabel("Vaps Clone", SwingConstants.CENTER);
        appNameLabel.setFont(new Font("Arial", Font.BOLD, 50));
        appNameLabel.setForeground(new Color(0, 77, 0)); // Koyu yeşil başlık rengi
        mainPanel.add(appNameLabel, BorderLayout.CENTER);

        // Create a button to navigate to another page
        btnNext = new javax.swing.JButton("Continue");
        btnNext.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
        btnNext.setBackground(new Color(255, 255, 255)); // Beyaz arka plan
        btnNext.setForeground(new Color(0, 77, 0)); // Koyu yeşil metin
        btnNext.setFocusPainted(false); // Remove focus border
        btnNext.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding

        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        // Add the button to the bottom of the main panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 240)); // Arka plan rengiyle eşleşen renk
        buttonPanel.add(btnNext);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WelcomePage wp = new WelcomePage();
                wp.setVisible(true);
            }
        });
    }
}
