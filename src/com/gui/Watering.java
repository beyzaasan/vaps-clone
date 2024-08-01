package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Watering extends javax.swing.JFrame {
    private int waterCount = 0; // Counter for water drops
    private Button button;
    private JPanel waterPanel; // Updated to JPanel
    private JPanel mainPanel;

    public Watering() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Watering System");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel with BorderLayout
        mainPanel = new JPanel(new BorderLayout());

        button = new Button();
        button.setPreferredSize(new Dimension(400, 200));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                waterCount = (waterCount + 1) % 4; // Cycle through 0 to 3
                updateWaterDrops();
                button.repaint(); // Repaint the knob to show the updated count
            }
        });

        waterPanel = new JPanel(); // Updated to JPanel
        waterPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center align the water drops

        // Add button and waterPanel to mainPanel
        mainPanel.add(button, BorderLayout.CENTER);
        mainPanel.add(waterPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        getContentPane().add(mainPanel);
        setVisible(true);
    }

    public JPanel getJPanel() {
        return mainPanel;
    }

    private void updateWaterDrops() {
        waterPanel.removeAll();
        for (int i = 0; i < waterCount; i++) {
            waterPanel.add(new Water());
        }
        waterPanel.revalidate();
        waterPanel.repaint();
    }

    class Button extends JPanel {
        @SuppressWarnings("unused")
        private BufferedImage image;

        public Button() {
            try {
                image = ImageIO.read(getClass().getResource("../../images/blue.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Get the panel's width and height
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int xOffset = 0;
        int yOffset = 0;

        // Draw the circular knob
        if (image != null) {
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();

            // Calculate x and y offsets to center the image
            xOffset = (panelWidth - imageWidth) / 2;
            yOffset = (panelHeight - imageHeight) / 2;

            // Draw the image centered in the panel
            g.drawImage(image, xOffset, yOffset, this);
        }
            g.setColor(Color.WHITE);
            g.drawString("2", panelWidth / 2 - 10, panelHeight / 2 + 90);
            g.drawString("1", panelWidth / 2 + 70, panelHeight / 2 );
            g.drawString("0", panelWidth / 2 - 10, panelHeight / 2 - 70);
            g.drawString("3", panelWidth / 2 - 80, panelHeight / 2);
            g.drawLine(panelWidth / 2, panelHeight / 2, panelWidth / 2 + (int) (60 * Math.cos(Math.toRadians(waterCount * 90 - 90))), panelHeight / 2 + (int) (60 * Math.sin(Math.toRadians(waterCount * 90 - 90))));
        }
    }

    class Water extends JPanel {
        private BufferedImage image;

        public Water() {
            try {
                image = ImageIO.read(getClass().getResource("../../images/drop-2.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            setPreferredSize(new Dimension(50, 50));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Watering();
        });
    }
}
