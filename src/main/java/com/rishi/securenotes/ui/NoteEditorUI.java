package com.rishi.securenotes.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NoteEditorUI extends JFrame {

    private JTextField titleField;
    private JTextArea contentArea;
    private JButton saveBtn, cancelBtn;

    public NoteEditorUI() {

        setTitle("New Note");
        setSize(600, 450);
        setLocationRelativeTo(null);

        setContentPane(new GradientPanel());
        setLayout(new BorderLayout(15, 15));

        initUI();
    }

    private void initUI() {


        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        titleField = createInput("Enter note title...");


        contentArea = new JTextArea();
        contentArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        contentArea.setBackground(new Color(45, 45, 70));
        contentArea.setForeground(Color.WHITE);
        contentArea.setCaretColor(Color.WHITE);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(contentArea);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(70,70,100)));


        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);

        saveBtn = new JButton(" Save", UIUtils.loadIcon("save.png", 18));
        cancelBtn = new JButton(" Cancel", UIUtils.loadIcon("exit.png", 18));

        saveBtn.setBackground(new Color(124, 58, 237));
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFocusPainted(false);

        buttonPanel.add(saveBtn);
        buttonPanel.add(cancelBtn);


        mainPanel.add(titleField, BorderLayout.NORTH);
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }


    private JTextField createInput(String placeholder) {

        JTextField field = new JTextField();

        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setBackground(new Color(45, 45, 70));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);

        field.setPreferredSize(new Dimension(200, 40));

        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70,70,100)),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));

        field.setText(placeholder);
        field.setForeground(new Color(150,150,170));

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.WHITE);
                }
            }

            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(new Color(150,150,170));
                }
            }
        });

        return field;
    }



    public String getNoteTitle() {
        return titleField.getText();
    }

    public String getNoteContent() {
        return contentArea.getText();
    }

    public void addSaveListener(ActionListener l) {
        saveBtn.addActionListener(l);
    }

    public void addCancelListener(ActionListener l) {
        cancelBtn.addActionListener(l);
    }
}