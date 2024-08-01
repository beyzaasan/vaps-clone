package com.gui;

import javax.swing.*;
import java.awt.*;

public class All extends JFrame {

    public All() {
        initComponents();
    }

    private void initComponents() {
        setTitle("All Panels");
        setSize(1200, 900); // Panel boyutlarına göre genişletildi
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around each panel

        // Create and add the panels
        JPanel tempPanel = new Temperature().getJPanel();
        JPanel lightPanel = new Lighting().getJPanel();
        JPanel soilPanel = new SoilAcidity().getJPanel();
        JPanel waterPanel = new Watering().getJPanel();

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        mainPanel.add(createPanelWithBorder("Watering", waterPanel), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        mainPanel.add(createPanelWithBorder("Lighting", lightPanel), gbc);

        //
        gbc.gridx = 2;
        gbc.gridy = 1;
        mainPanel.add(createPanelWithBorder("Temperature", tempPanel), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        mainPanel.add(createPanelWithBorder("Soil Acidity", soilPanel), gbc);

        // Add title label at the top
        JLabel titleLabel = new JLabel("Control Panel", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(new Color(0, 77, 0)); // Dark green color
        titleLabel.setPreferredSize(new Dimension(getWidth(), 60));

        // Add title and mainPanel to the frame
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createPanelWithBorder(String title, JPanel panel) {
        JPanel borderedPanel = new JPanel(new BorderLayout());
        borderedPanel.setBorder(BorderFactory.createTitledBorder(title));
        borderedPanel.add(panel, BorderLayout.CENTER);
        return borderedPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new All());
    }
}
