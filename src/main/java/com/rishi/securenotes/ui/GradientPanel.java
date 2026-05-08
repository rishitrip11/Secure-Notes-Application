package com.rishi.securenotes.ui;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;


        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        GradientPaint gp = new GradientPaint(
                0, 0, new Color(10, 10, 25),
                getWidth(), getHeight(), new Color(40, 20, 80)
        );

        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());


        g2.setColor(new Color(124, 58, 237, 60));
        g2.fillOval(getWidth()/2 - 200, getHeight()/2 - 200, 400, 400);
    }
}