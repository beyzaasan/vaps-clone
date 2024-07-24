package com.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    JFrame mainFrame;

    public Main(){
        initComponents();
    }

    private void initComponents() {
        
        mainFrame = new JFrame("Vaps Clone");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);

        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a JSplitPane to divide the panel into left and right sections
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(400); // Set initial divider location
        splitPane.setDividerSize(2); // Set the size of the divider

        // Create the left panel with a list
        JPanel leftPanel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Item 1");
        listModel.addElement("Item 2");
        listModel.addElement("Item 3");
        listModel.addElement("Item 4");
        listModel.addElement("Item 5");
        JList<String> list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(10);
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedItem = list.getSelectedValue();
                JOptionPane.showMessageDialog(this, "You selected: " + selectedItem);
            }
        });
        leftPanel.add(new JScrollPane(list), BorderLayout.CENTER);

        // Create the right panel for other content
        JPanel rightPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Right Panel", SwingConstants.CENTER);
        rightPanel.add(label, BorderLayout.CENTER);

        // Add the panels to the split pane
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);

        // Add the split pane to the main panel
        mainPanel.add(splitPane, BorderLayout.CENTER);

        // Add the main panel to the frame
        mainFrame.add(mainPanel);

        // Make the frame visible after adding components
        mainFrame.setVisible(true);
    }

}


