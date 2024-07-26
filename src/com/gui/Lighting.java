package com.gui;

import javax.swing.*;

import com.gui.Temperature.TempScroll;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Lighting extends javax.swing.JFrame {

    public Lighting(){
        initComponents();
    }

    private void initComponents(){

        setTitle("Lighting");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel stablePanel = new JPanel();
        stablePanel.setLayout(new BoxLayout(stablePanel, BoxLayout.Y_AXIS)); //alt alta olması için
        StablePanel stabPanel = new StablePanel();
        stablePanel.add(stabPanel);

        JPanel statePanel = new JPanel();
        statePanel.setLayout(new BoxLayout(statePanel, BoxLayout.Y_AXIS));
        StatePanel statPanel = new StatePanel(); 
        stablePanel.add(statPanel);

        JPanel showPanel = new JPanel();
        showPanel.setLayout(new BoxLayout(showPanel, BoxLayout.Y_AXIS));

        mainPanel.add(stablePanel, BorderLayout.WEST);
        mainPanel.add(statePanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

        class StablePanel extends JPanel{
            private BufferedImage image1, image2, image3;
            private int x = 0;
            private int y = 0;
        
            public StablePanel() {
        
                try {
                    File file1 = new File("/Users/beyzaasan/Downloads/red-2.png");
                    image1 = ImageIO.read(file1);
                    File file2 = new File("/Users/beyzaasan/Downloads/orange-2.png");
                    image2 = ImageIO.read(file2);
                    File file3 = new File("/Users/beyzaasan/Downloads/yellow-2.png");
                    image3 = ImageIO.read(file3);
                    if (image1 != null && image2 != null && image3 != null) {
                        System.out.println("Images1 loaded successfully");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                System.out.println("paintComponent called");
                int yOffset = 0;
                if (image1 != null) {
                    g.drawImage(image1, x, y + yOffset, this);
                    yOffset += image1.getHeight();
                }
                if (image2 != null) {
                    g.drawImage(image2, x, y + yOffset, this);
                    yOffset += image2.getHeight();
                }
                if (image3 != null) {
                    g.drawImage(image3, x, y + yOffset, this);
                }
            }
        }

        class StatePanel extends JPanel{
            private BufferedImage image4, image5;
            private BufferedImage[] images;
            private int selectedIndex = -1;
        
            public StatePanel() {
        
                try {
                    File file4 = new File("/Users/beyzaasan/Downloads/grey-3.png");
                    image4 = ImageIO.read(file4);
                    File file5 = new File("/Users/beyzaasan/Downloads/blue-2.png");
                    image5 = ImageIO.read(file5);

                    images = new BufferedImage[] { image4, image4, image4 };
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            

                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int panelWidth = getWidth();
                        int panelHeight = getHeight();
                        int sectionHeight = panelHeight / 3;  // Height of each section
        
                        // Determine which section was clicked
                        if (e.getY() < sectionHeight) {
                            selectedIndex = 0;
                        } else if (e.getY() < 2 * sectionHeight) {
                            selectedIndex = 1;
                        } else if (e.getY() < 3 * sectionHeight) {
                            selectedIndex = 2;
                        }
        
                        if (selectedIndex != -1) {
                            // Replace the image in the selected section with image5
                            images[selectedIndex] = image5;
                            repaint();
                        }
                    }
                });
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int yOffset = 0;
                int sectionHeight = getHeight() / 3; 

                for (BufferedImage img : images) {
                    if (img != null) {
                        g.drawImage(img, 0, yOffset, getWidth(), sectionHeight, this);
                        yOffset += sectionHeight;
                    }
                }
            }
        }

        class ShowPanel extends JPanel{
            
        }
    
}
