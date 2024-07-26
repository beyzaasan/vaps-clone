package com.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Temperature extends javax.swing.JFrame {

    private JSlider slider;
    private JLabel tempLabel;

    public Temperature(){
        initComponents();
    }

    private void initComponents(){
        setTitle("Temperature");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(1,2));
        //mainPanel.setLayout(new BorderLayout());

        /*JPanel whiteDashPanel = new JPanel();
        //whiteDashPanel.setLayout(new BorderLayout());
        whiteDashPanel.setPreferredSize(new Dimension(200, 300));

        JLabel whiteDash = new JLabel("|");
        // Set the font size and color
        whiteDash.setFont(new Font("Arial", Font.BOLD, 200)); // Adjust size as needed
        whiteDash.setForeground(Color.WHITE);
        whiteDashPanel.setLayout(new BoxLayout(whiteDashPanel, BoxLayout.Y_AXIS));
        whiteDashPanel.add(whiteDash, BorderLayout.CENTER);

        TempScroll tempScroll = new TempScroll(whiteDash); // Example position and size
        whiteDashPanel.add(tempScroll);*/

        tempLabel = new JLabel("25.0", JLabel.CENTER);
        tempLabel.setFont(new Font("Serif", Font.BOLD, 48));
        tempLabel.setOpaque(true);

        // Slider
        slider = new JSlider(JSlider.VERTICAL, 200, 500, 250); 
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double temp = slider.getValue() / 10.0;
                tempLabel.setText(String.valueOf(temp));
                //updateLabelColor(temp);
                //colorPanel.repaint();
            }
        });

        JPanel dashPanel = new JPanel(); //dashler alt alta olsun diye yeni center alignment yapcam
        dashPanel.setLayout(new BoxLayout(dashPanel, BoxLayout.Y_AXIS));
        
        // Number of dashes
        int numberOfDashes = 10 * 5; // You can change this to add more or fewer dashes

        for (int i = numberOfDashes; i >= 20; i-=3) {
            JLabel dashLabel = new JLabel("—  " + i);
            dashLabel.setFont(new Font("Serif", Font.PLAIN, 18));
            dashLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally
            dashPanel.add(dashLabel);
        }

        //mainPanel.add(whiteDashPanel, BorderLayout.WEST);
        mainPanel.add(tempLabel, BorderLayout.SOUTH);
        mainPanel.add(slider, BorderLayout.CENTER);
        mainPanel.add(dashPanel, BorderLayout.CENTER);

        // Add main panel to frame
        getContentPane().add(mainPanel);

        setVisible(true);
    }

    private void updatePhotos(double temp) {
        if (temp >= 1.0 && temp <= 5.0) {
            //foto1
        } else if (temp >= 5.1 && temp <= 9.0) {
            //foto2
        } else if (temp >= 9.1 && temp <= 14.0) {
            //foto3
        }
    }

    class TempScroll extends JPanel {
        private BufferedImage image;
        private int x = 0;
        private int y = 0;
        private int prevY = 0;
        private boolean dragging = false;
        private JLabel whiteDash;
    
        public TempScroll(JLabel whiteDash) {
            this.whiteDash = whiteDash;
    
            try {
                image = ImageIO.read(getClass().getResource("../../images/button-2.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            y = whiteDash.getY() + (whiteDash.getHeight() - image.getHeight()) / 2;    
            addMouseListener(new MouseListener() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getX() >= x && e.getX() <= x + image.getWidth() && e.getY() >= y && e.getY() <= y + image.getHeight()) {
                        dragging = true;
                        prevY = e.getY();
                    }
                }
    
                @Override
                public void mouseReleased(MouseEvent e) {
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
                        int deltaY = e.getY() - prevY;
                        int newY = y + deltaY;
    
                        // Restrict movement within the bounds of the white dash label
                        int whiteDashHeight = whiteDash.getHeight();
                        int maxY = whiteDash.getY() + whiteDashHeight - image.getHeight();
                        if (newY >= whiteDash.getY() && newY <= maxY) {
                            y = newY;
                            prevY = e.getY();
                            repaint();
                        }
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
