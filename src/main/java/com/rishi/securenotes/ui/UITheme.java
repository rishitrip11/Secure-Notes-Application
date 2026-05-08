package com.rishi.securenotes.ui;

import java.awt.*;

public class UITheme {

    public static final Color BG1 = new Color(10, 10, 25);
    public static final Color BG2 = new Color(40, 20, 80);

    public static final Color CARD = new Color(30, 30, 50, 200);
    public static final Color INPUT = new Color(45, 45, 70);
    public static final Color PRIMARY = new Color(124, 58, 237);

    public static final Color TEXT = Color.WHITE;
    public static final Color SUBTEXT = new Color(180,180,200);

    public static Font TITLE = new Font("Segoe UI", Font.BOLD, 26);
    public static Font NORMAL = new Font("Segoe UI", Font.PLAIN, 15);

    public static void applyQuality(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }
}