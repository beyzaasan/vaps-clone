package images;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;

public class UMLPanel extends JFrame {

    Images images;
    JPanel mainPanel;

    public UMLPanel() {

        mainPanel = new JPanel(new BorderLayout());

        setTitle("UML Diagram Maker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel toolPanel = new JPanel();
        toolPanel.setPreferredSize(new Dimension(1000, 1000));

        // Araç çubuğu bileşenlerini ekleyin
        images = new Images();
        toolPanel.add(images);
        
        // Sağ taraftaki ana alan
        JPanel drawingPanel = new JPanel();
        drawingPanel.setBackground(Color.WHITE);
        
        mainPanel.add(toolPanel, BorderLayout.WEST);
        mainPanel.add(drawingPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
        mainPanel.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UMLPanel panel = new UMLPanel();
        });
    }

    class Images extends JPanel{
            private BufferedImage image1, image2, image3, image4,image5,image6;
            private int x = 0;
            private int y = 0;
            private BufferedImage[] images;
        
            public Images() {
        
                try {
                    image1 = ImageIO.read(getClass().getResource("çember.png"));
                    image2 = ImageIO.read(getClass().getResource("çizgi.png"));
                    image3 = ImageIO.read(getClass().getResource("çift_çizgi.png"));
                    image4 = ImageIO.read(getClass().getResource("dikdörtgen.png"));
                    image5 = ImageIO.read(getClass().getResource("kare.png"));
                    image6 = ImageIO.read(getClass().getResource("yön_oku.png"));

                    images = new BufferedImage[]{image1, image2, image3, image4, image5, image6};
                    if (image1 != null && image2 != null && image3 != null && image4 != null && image5 != null && image6 != null) {
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
}


