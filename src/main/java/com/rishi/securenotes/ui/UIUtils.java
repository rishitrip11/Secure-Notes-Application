package com.rishi.securenotes.ui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class UIUtils {

    public static ImageIcon loadIcon(String name, int size) {

        URL url = UIUtils.class.getClassLoader().getResource("icons/" + name);

        if (url == null) {
            System.out.println("ICON NOT FOUND: " + name);
            return new ImageIcon();
        }

        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);

        return new ImageIcon(img);
    }
}