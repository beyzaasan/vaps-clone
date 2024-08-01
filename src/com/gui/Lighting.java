package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;

public class Lighting extends JFrame {

    ShowPanel shPanel;
    StablePanel stabPanel;
    StatePanel statPanel;
    JPanel mainPanel;

    public Lighting(){
        initComponents();
    }

    private void initComponents(){

        setTitle("Lighting");
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3, 10, 10)); // 1 satır, 3 sütun, aralarında 10 piksel boşluk
        mainPanel.setBackground(new Color(255, 250, 240)); // Soft beige background

        stabPanel = new StablePanel();
        stabPanel.setPreferredSize(new Dimension(200, 600)); // Panel boyutunu ayarla
        stabPanel.setBackground(new Color(240, 230, 220)); // Light beige background

        statPanel = new StatePanel();
        statPanel.setPreferredSize(new Dimension(200, 600)); // Panel boyutunu ayarla
        statPanel.setBackground(new Color(240, 230, 220)); // Light beige background

        shPanel = new ShowPanel();
        shPanel.setPreferredSize(new Dimension(200, 600)); // Panel boyutunu ayarla
        shPanel.setBackground(new Color(240, 230, 220)); // Match main panel background

        mainPanel.add(stabPanel);
        mainPanel.add(statPanel);
        mainPanel.add(shPanel);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    public JPanel getJPanel(){
        return mainPanel;
    }

    public JLabel getHeading(Lighting lighting){
        JLabel label = new JLabel("Lighting", SwingConstants.CENTER);
        return label;
    }

    class StablePanel extends JPanel {
        private BufferedImage image1, image2, image3;
        private BufferedImage[] images;

        public StablePanel() {
            try {
                image1 = ImageIO.read(getClass().getResource("../../images/red-2.png"));
                image2 = ImageIO.read(getClass().getResource("../../images/orange-2.png"));
                image3 = ImageIO.read(getClass().getResource("../../images/yellow-2.png"));
                images = new BufferedImage[]{image1, image2, image3};
                if (image1 != null && image2 != null && image3 != null) {
                    System.out.println("Images1 loaded successfully");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public BufferedImage getImage(int index) {
            if (index >= 0 && index < images.length) {
                return images[index];
            }
            return null;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Get the panel's width and height
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calculate the total height of all images
            int totalImageHeight = 0;
            if (image1 != null) totalImageHeight += image1.getHeight();
            if (image2 != null) totalImageHeight += image2.getHeight();
            if (image3 != null) totalImageHeight += image3.getHeight();

            // Calculate the starting yOffset to center vertically
            int yOffset = (panelHeight - totalImageHeight) / 2;

            if (image1 != null) {
                int imageWidth = image1.getWidth();
                int xOffset1 = (panelWidth - imageWidth) / 2; // Center image horizontally
                g.drawImage(image1, xOffset1, yOffset, this);
                yOffset += image1.getHeight(); // Move yOffset down for the next image
            }
            if (image2 != null) {
                int imageWidth = image2.getWidth();
                int xOffset2 = (panelWidth - imageWidth) / 2; // Center image horizontally
                g.drawImage(image2, xOffset2, yOffset, this);
                yOffset += image2.getHeight(); // Move yOffset down for the next image
            }
            if (image3 != null) {
                int imageWidth = image3.getWidth();
                int xOffset3 = (panelWidth - imageWidth) / 2; // Center image horizontally
                g.drawImage(image3, xOffset3, yOffset, this);
            }
        }

    }

    class StatePanel extends JPanel {
        private BufferedImage image4, image5;
        private BufferedImage[] images;
        private int selectedIndex = -1;

        public StatePanel() {
            try {
                image4 = ImageIO.read(getClass().getResource("../../images/grey-3.png"));
                image5 = ImageIO.read(getClass().getResource("../../images/blue-2.png"));
                images = new BufferedImage[]{image4, image4, image4};
            } catch (Exception e) {
                e.printStackTrace();
            }

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
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
                        // Reset all sections to grey
                        for (int i = 0; i < images.length; i++) {
                            images[i] = image4;
                        }
                        // Set the selected section to blue
                        images[selectedIndex] = image5;
                        repaint();
                        updateShowPanel();
                    }
                }

                private void updateShowPanel() {
                    BufferedImage selectedImage = null;
                    if (selectedIndex != -1) {
                        selectedImage = stabPanel.getImage(selectedIndex);
                    }
                    shPanel.setImages(selectedImage);
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

    class ShowPanel extends JPanel {
        private BufferedImage image;

        public ShowPanel() {
            setPreferredSize(new Dimension(200, 600)); // Panel boyutunu ayarla
        }

        public void setImages(BufferedImage imgs) {
            this.image = imgs;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                int x = (getWidth() - image.getWidth()) / 2;
                int y = (getHeight() - image.getHeight()) / 2;
                g.drawImage(image, x, y, this);
            }
        }
    }

}

