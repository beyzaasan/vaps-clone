package com.gui;

import java.awt.*;
import javax.swing.*;

public class NewControlPanel extends JFrame{
    private JTabbedPane tabbedPane;

    public NewControlPanel() {
        initComponents();
    }

    private void initComponents() {
        setTitle("All Panels");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 250, 240)); // Beige-like background

        // Create a JTabbedPane
        tabbedPane = new JTabbedPane();

        // Add each panel to the tabbedPane
        tabbedPane.addTab("Temperature", new Temperature().getJPanel());
        tabbedPane.addTab("Lighting", new Lighting().getJPanel());
        tabbedPane.addTab("Soil Acidity", new SoilAcidity().getJPanel());
        tabbedPane.addTab("Watering", new Watering().getJPanel());

        // Add the tabbedPane to the mainPanel
        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        // Add a title label at the top
        JLabel titleLabel = new JLabel("Control Panels", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(new Color(0, 77, 0)); // Dark green color
        titleLabel.setPreferredSize(new Dimension(getWidth(), 80));

        // Add the title and mainPanel to the frame
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NewControlPanel());
    }
}
