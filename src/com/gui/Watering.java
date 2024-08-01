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
    JPanel mainPanel;

    public Watering() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Watering System");
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

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
        waterPanel.setLayout(new BoxLayout(waterPanel, BoxLayout.X_AXIS));

        mainPanel.add(button, BorderLayout.CENTER);
        mainPanel.add(waterPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        getContentPane().add(mainPanel);
        
        setVisible(true);
    }

    public JPanel getJPanel(){
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
                File file = new File("../../images/blue.png");
                image = ImageIO.read(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the circular knob
            g.setColor(Color.BLUE);
            g.fillOval(100, 20, 200, 200);
            g.setColor(Color.WHITE);
            g.drawString("2", 190, 220);
            g.drawString("1", 270, 150);
            g.drawString("0", 190, 80);
            g.drawString("3", 110, 150);
            g.drawLine(200, 120, 200 + (int) (60 * Math.cos(Math.toRadians(waterCount * 90 - 90))), 120 + (int) (60 * Math.sin(Math.toRadians(waterCount * 90 - 90))));
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