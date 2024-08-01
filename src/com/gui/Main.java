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
        topPanel.setBackground(new Color(240, 240, 240));  // Açık gri arka plan
        topPanel.setPreferredSize(new Dimension(800, 150));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Boşluklar
    
        // Logo veya ikon ekle
        JLabel logoLabel = new JLabel();
        try {
            ImageIcon logoIcon = new ImageIcon(getClass().getResource("../../images/pace.png")); // İkon yolunu güncelleyin
            logoLabel.setIcon(logoIcon);
        } catch (Exception e) {
            e.printStackTrace(); // İkon yüklenemezse hata mesajı yazdır
            logoLabel.setText("Logo not found");
        }
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setOpaque(true);
        logoLabel.setBackground(new Color(208, 208, 208));
    
        // Logo'nun üstte ortalanması
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        topPanel.add(logoLabel, gbc);
    
        // Başlık metni
        JLabel titleLabel = new JLabel("Data Display");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(new Color(0, 77, 0));  // Koyu yeşil metin
    
        // Başlığı logonun altına yerleştirme
        gbc.gridy = 1;  // Başlık bir satır altına
        topPanel.add(titleLabel, gbc);
    
        // Alt kısım
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(240, 240, 240));  // Açık gri arka plan
        bottomPanel.setLayout(new GridLayout(1, 4, 20, 20));  // Daha fazla boşluk
    
        // Kategoriler
        String[] categories = {"Temperature", "Lighting", "Watering", "SoilAcidity"};
        for (String category : categories) {
            JButton button = new JButton(category);
            button.setPreferredSize(new Dimension(150, 100));
            button.setForeground(new Color(0, 77, 0));  // Koyu yeşil metin
            button.setBackground(new Color(255, 255, 255));  // Beyaz arka plan
            button.setFocusPainted(false);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setBorder(BorderFactory.createLineBorder(new Color(128, 224, 164), 2)); // Açık yeşil kenar çizgisi
    
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (category.equals("Temperature")) { 
                        new Temperature().setVisible(true);
                    } else if (category.equals("Lighting")) {
                        new Lighting().setVisible(true);
                    } else if (category.equals("Watering")) {
                        new Watering().setVisible(true);
                    } else if (category.equals("SoilAcidity")) {
                        new SoilAcidity().setVisible(true);
                    } else {
                        //
                    }
                }
            });
            bottomPanel.add(button);
        }
    
        JButton all = new JButton("Show all panel together");
        all.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));
        all.setBackground(new Color(255, 255, 255)); // Beyaz arka plan
        all.setForeground(new Color(0, 77, 0)); // Koyu yeşil metin
        all.setFocusPainted(false);
    
        all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAll(evt);
            }
        });
    
        // Add panels to main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);
        mainPanel.add(all, BorderLayout.SOUTH);
    
        getContentPane().add(mainPanel);
    }     

    private void btnShowAll(java.awt.event.ActionEvent evt) {
        // Open the main frame
        new All().setVisible(true);
        System.out.println("All loaded");
    }
}


