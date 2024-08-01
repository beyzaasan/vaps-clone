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
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new GridLayout(2,2));

        Lighting lighting = new Lighting();
        //lighting.getJPanel().add(new JLabel("Lighting"));
        SoilAcidity soilAcidity = new SoilAcidity();
        //soilAcidity.getJPanel().add(new JLabel("soilAcidity"));
        Temperature temperature = new Temperature();
        //temperature.getJPanel().add(new JLabel("temperature"));
        Watering watering = new Watering();
        //watering.getJPanel().add(new JLabel("watering"));

        mainPanel.add(lighting.getJPanel());
        mainPanel.add(soilAcidity.getJPanel());
        mainPanel.add(temperature.getJPanel());
        mainPanel.add(watering.getJPanel());

        getContentPane().add(mainPanel);
        setVisible(true);

    }
}
