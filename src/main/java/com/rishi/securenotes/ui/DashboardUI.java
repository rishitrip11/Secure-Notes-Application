package com.rishi.securenotes.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DashboardUI extends JFrame {

    private JLabel greetingLabel;
    private JLabel totalLabel;
    private JLabel encryptedLabel;
    private JLabel plainLabel;

    private JButton createBtn;
    private JButton viewBtn;
    private JButton logoutBtn;

    public DashboardUI() {

        setTitle("Secure Notes — Dashboard");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new GradientPanel());
        setLayout(new BorderLayout());

        initUI();
    }

    private void initUI() {


        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        header.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel title = new JLabel(" Secure Notes");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.WHITE);

        greetingLabel = new JLabel("Hello ");
        greetingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        greetingLabel.setForeground(new Color(180,180,200));

        header.add(title, BorderLayout.WEST);
        header.add(greetingLabel, BorderLayout.EAST);

        // 🔹 STATS PANEL
        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 15, 15));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        totalLabel = createStatCard("Total", "0");
        encryptedLabel = createStatCard("Encrypted", "0");
        plainLabel = createStatCard("Plain", "0");

        statsPanel.add(totalLabel);
        statsPanel.add(encryptedLabel);
        statsPanel.add(plainLabel);


        JPanel actionPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        actionPanel.setOpaque(false);
        actionPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        createBtn = createCardButton(" New Note", UIUtils.loadIcon("newnote.png", 24));
        viewBtn = createCardButton(" My Notes", UIUtils.loadIcon("notes.png", 24));

        actionPanel.add(createBtn);
        actionPanel.add(viewBtn);


        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setOpaque(false);

        centerWrapper.add(statsPanel, BorderLayout.NORTH);
        centerWrapper.add(actionPanel, BorderLayout.CENTER);


        JPanel bottom = new JPanel();
        bottom.setOpaque(false);
        bottom.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        logoutBtn = new JButton("Logout");
        logoutBtn.setBackground(new Color(124, 58, 237));
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFocusPainted(false);

        bottom.add(logoutBtn);


        add(header, BorderLayout.NORTH);
        add(centerWrapper, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }


    private JLabel createStatCard(String title, String value) {

        JLabel label = new JLabel(
                "<html><center><span style='font-size:20px'>" + value + "</span><br>" + title + "</center></html>",
                SwingConstants.CENTER
        );

        label.setOpaque(true);
        label.setBackground(new Color(30, 30, 50, 220));
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        return label;
    }


    private JButton createCardButton(String text, Icon icon) {

        JButton btn = new JButton(text, icon);

        btn.setPreferredSize(new Dimension(200, 150));
        btn.setBackground(new Color(30, 30, 50, 220));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setFocusPainted(false);

        return btn;
    }




    public void setUsername(String username) {
        greetingLabel.setText("Hello, " + username );
    }

    public void setNoteStats(int total, int encrypted) {
        totalLabel.setText("<html><center><span style='font-size:20px'>" + total + "</span><br>Total</center></html>");
        encryptedLabel.setText("<html><center><span style='font-size:20px'>" + encrypted + "</span><br>Encrypted</center></html>");
        plainLabel.setText("<html><center><span style='font-size:20px'>" + (total - encrypted) + "</span><br>Plain</center></html>");
    }

    public void addCreateNoteListener(ActionListener l) {
        createBtn.addActionListener(l);
    }

    public void addViewNotesListener(ActionListener l) {
        viewBtn.addActionListener(l);
    }

    public void addLogoutListener(ActionListener l) {
        logoutBtn.addActionListener(l);
    }
}
