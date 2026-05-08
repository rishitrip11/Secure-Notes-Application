package com.rishi.securenotes.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton actionBtn, switchBtn;

    private boolean isLogin = true;

    public LoginUI() {

        setTitle("Secure Notes");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(new GradientPanel());
        setLayout(new GridBagLayout());

        add(createCard());
    }

    // 🔹 MAIN CARD
    private JPanel createCard() {

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(360, 320));
        card.setBackground(new Color(30, 30, 50, 220));
        card.setLayout(new GridLayout(5, 1, 12, 14));
        card.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel title = new JLabel("Secure Notes", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(Color.WHITE);

        usernameField = createInput("Username");

        passwordField = new JPasswordField();
        stylePassword(passwordField);

        actionBtn = createPrimaryButton("Login");
        switchBtn = createSecondaryButton("Create account");

        // 🔁 toggle login/register
        switchBtn.addActionListener(e -> {
            isLogin = !isLogin;
            actionBtn.setText(isLogin ? "Login" : "Register");
            switchBtn.setText(isLogin ? "Create account" : "Back to login");
        });

        card.add(title);
        card.add(usernameField);
        card.add(passwordField);
        card.add(actionBtn);
        card.add(switchBtn);

        return card;
    }


    private JTextField createInput(String placeholder) {

        JTextField field = new JTextField();

        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setBackground(new Color(45, 45, 70));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);


        field.setPreferredSize(new Dimension(200, 40));


        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 100)),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));


        field.setText(placeholder);
        field.setForeground(new Color(150, 150, 170));

        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.WHITE);
                }
            }

            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(new Color(150, 150, 170));
                }
            }
        });

        return field;
    }


    private void stylePassword(JPasswordField field) {

        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setBackground(new Color(45, 45, 70));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);

        field.setPreferredSize(new Dimension(200, 40));

        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 100)),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
    }


    private JButton createPrimaryButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(124, 58, 237));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setFocusPainted(false);
        return btn;
    }


    private JButton createSecondaryButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(30, 30, 50));
        btn.setForeground(new Color(180, 180, 200));
        btn.setBorder(null);
        return btn;
    }


    public String getUsername() {
        return usernameField.getText();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }

    public boolean isLoginMode() {
        return isLogin;
    }

    public void addLoginListener(ActionListener l) {
        actionBtn.addActionListener(l);
    }

    public void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void showSuccess(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}