package com.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SoilAcidity extends JFrame {
    private JSlider slider;
    private JLabel phLabel;
    private JPanel colorPanel;
    JPanel mainPanel;

    public SoilAcidity() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Soil Acidity");
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        mainPanel = new JPanel(new BorderLayout());

        // PH Label
        phLabel = new JLabel("7", JLabel.CENTER);
        phLabel.setFont(new Font("Serif", Font.BOLD, 48));
        phLabel.setOpaque(true);
        updateLabelColor(7.0);

        // Color Panel
        colorPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the red, yellow, and green zones
                int width = getWidth();
                int height = getHeight();
                g.setColor(Color.RED);
                g.fillRect(0, 0, width / 3, height);
                g.setColor(Color.YELLOW);
                g.fillRect(width / 3, 0, width / 3, height);
                g.setColor(Color.GREEN);
                g.fillRect(2 * width / 3, 0, width / 3, height);
            }
        };
        colorPanel.setPreferredSize(new Dimension(300, 50));

        // Slider
        slider = new JSlider(10, 140, 70); // pH range from 1.0 to 14.0
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double phValue = slider.getValue() / 10.0;
                phLabel.setText(String.valueOf(phValue));
                updateLabelColor(phValue);
                colorPanel.repaint();
            }
        });

        // Add components to the main panel
        mainPanel.add(phLabel, BorderLayout.NORTH);
        mainPanel.add(colorPanel, BorderLayout.CENTER);
        mainPanel.add(slider, BorderLayout.SOUTH);

        // Add main panel to the frame
        getContentPane().add(mainPanel);
        setVisible(true);
    }

    private void updateLabelColor(double phValue) {
        if (phValue >= 1.0 && phValue <= 5.0) {
            phLabel.setBackground(Color.RED);
        } else if (phValue >= 5.1 && phValue <= 9.0) {
            phLabel.setBackground(Color.YELLOW);
        } else if (phValue >= 9.1 && phValue <= 14.0) {
            phLabel.setBackground(Color.GREEN);
        }
    }

    public JPanel getJPanel(){
        return mainPanel;
    }

}

