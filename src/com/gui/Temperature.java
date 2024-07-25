package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Temperature extends javax.swing.JFrame {

    public Temperature(){
        initComponents();
    }

    private void initComponents(){
        setTitle("Temperature");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel whiteDashPanel = new JPanel();
        //whiteDashPanel.setLayout(new BorderLayout());
        whiteDashPanel.setPreferredSize(new Dimension(200, 300));

        JLabel whiteDash = new JLabel("|");
        // Set the font size and color
        whiteDash.setFont(new Font("Arial", Font.BOLD, 200)); // Adjust size as needed
        whiteDash.setForeground(Color.WHITE);
        whiteDashPanel.setLayout(new BoxLayout(whiteDashPanel, BoxLayout.Y_AXIS));
        whiteDashPanel.add(whiteDash, BorderLayout.CENTER);

        TempScroll tempScroll = new TempScroll(); // Example position and size
        whiteDashPanel.add(tempScroll);

        JPanel dashPanel = new JPanel(); //dashler alt alta olsun diye yeni center alignment yapcam
        dashPanel.setLayout(new BoxLayout(dashPanel, BoxLayout.Y_AXIS));
        
        // Number of dashes
        int numberOfDashes = 10; // You can change this to add more or fewer dashes

        for (int i = 0; i < numberOfDashes; i++) {
            JLabel dashLabel = new JLabel("—  ");
            dashLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            dashLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally
            dashPanel.add(dashLabel);
        }

        mainPanel.add(whiteDashPanel, BorderLayout.WEST);
        mainPanel.add(dashPanel, BorderLayout.EAST);

        // Add main panel to frame
        getContentPane().add(mainPanel);

        setVisible(true);
    }
    class TempScroll extends JPanel{
        private BufferedImage image;
        private int x = 0;
        private int y = 0;
        private int prevY = 0;
        private boolean dragging = false;

        public TempScroll() {
            try {
                File file = new File("/Users/beyzaasan/Downloads/button-2.png");
                image = ImageIO.read(file);
            } catch (Exception e) {
                e.printStackTrace();
            }

            addMouseListener(new MouseListener() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // Mouse basıldığında, hareket etmeye başlayın
                    if (e.getX() >= x && e.getX() <= x + image.getWidth() && e.getY() >= y && e.getY() <= y + image.getHeight()) {
                        dragging = true;
                        prevY = e.getY();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Mouse bırakıldığında, hareket etmeyi durdurun
                    dragging = false;
                }

                @Override
                public void mouseClicked(MouseEvent e) {}
                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
            });

            addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (dragging) {
                        // Mouse hareket ederken, y koordinatını güncelle
                        int deltaY = e.getY() - prevY;
                        y += deltaY;
                        prevY = e.getY();
                        repaint();
                    }
                }

                @Override
                public void mouseMoved(MouseEvent e) {}
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, x, y, this);
        }
    }
}
