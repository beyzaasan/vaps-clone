package com.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

public class Temperature extends javax.swing.JFrame {

    private JSlider slider;
    private JLabel tempLabel;
    private JPanel mainPanel;

    public Temperature() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Temperature");
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 250, 240)); // Soft beige background

        // Temperature Label
        tempLabel = new JLabel("25.0", JLabel.CENTER);
        tempLabel.setFont(new Font("Arial", Font.BOLD, 48));
        tempLabel.setForeground(new Color(0, 77, 0)); // Dark green text
        tempLabel.setOpaque(true);
        tempLabel.setBackground(new Color(255, 255, 255)); // White background
        tempLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Slider
        slider = new JSlider(JSlider.VERTICAL, 200, 500, 250);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setBackground(new Color(255, 250, 240)); // Soft beige background

        // Slider Label Table
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        int[] tickValues = {200, 250, 300, 350, 400, 450, 500}; // Define specific tick values
        for (int value : tickValues) {
            int displayValue = value / 10; // Divide by 10 for display
            labelTable.put(value, new JLabel(String.valueOf(displayValue)));
        }
        slider.setLabelTable(labelTable);
        slider.setPaintLabels(true);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double temp = slider.getValue() / 10.0;
                tempLabel.setText(String.format("%.1f", temp));
            }
        });

        // Customize slider with border
        slider.setBorder(BorderFactory.createLineBorder(new Color(0, 77, 0), 2)); // Dark green border

        // Panel for slider
        JPanel sliderDashPanel = new JPanel(new BorderLayout());
        sliderDashPanel.setBackground(new Color(255, 250, 240)); // Match main panel background
        sliderDashPanel.add(slider, BorderLayout.CENTER);
        sliderDashPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 77, 0), 2)); // Dark green border

        // Add components to main panel
        mainPanel.add(tempLabel, BorderLayout.NORTH);
        mainPanel.add(sliderDashPanel, BorderLayout.CENTER);

        // Add main panel to frame
        getContentPane().add(mainPanel);
        setVisible(true);
    }

    public JPanel getJPanel() {
        return mainPanel;
    }
}
