package com.gui;

import javax.swing.*;
import java.awt.*;

public class All extends javax.swing.JFrame{

    JPanel mainPanel;

    public All(){
        initComponents();
    }

    private void initComponents(){
        setTitle("Vaps Clone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new GridLayout(2,2));

        Lighting lighting = new Lighting();
        SoilAcidity soilAcidity = new SoilAcidity();
        Temperature temperature = new Temperature();
        Watering watering = new Watering();

        mainPanel.add(lighting.getJPanel());
        mainPanel.add(soilAcidity.getJPanel());
        mainPanel.add(temperature.getJPanel());
        mainPanel.add(watering.getJPanel());

        getContentPane().add(mainPanel);
        setVisible(true);

    }
}
