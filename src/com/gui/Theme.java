package com.gui;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;

public class Theme {
    public static void applyDarkTheme() {
        try {
            // Set FlatLaf Dark theme
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }
}