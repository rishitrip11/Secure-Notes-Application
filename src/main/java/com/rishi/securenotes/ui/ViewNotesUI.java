package com.rishi.securenotes.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewNotesUI extends JFrame {

    private JList<String> list;
    private JTextArea preview;
    private DefaultListModel<String> model;
    private List<NoteRow> notes;

    private JButton deleteBtn, decryptBtn, backBtn;

    public ViewNotesUI() {

        setTitle("My Notes");
        setSize(900, 500);
        setLocationRelativeTo(null);

        setContentPane(new GradientPanel());
        setLayout(new BorderLayout());


        JPanel top = new JPanel();
        top.setOpaque(false);

        backBtn = new JButton(" Back", UIUtils.loadIcon("back.png", 20));
        decryptBtn = new JButton(" Decrypt", UIUtils.loadIcon("unlock.png", 20));
        deleteBtn = new JButton(" Delete", UIUtils.loadIcon("delete.png", 20));
        styleButton(backBtn);
        styleButton(decryptBtn);
        styleButton(deleteBtn);

        top.add(backBtn);
        top.add(decryptBtn);
        top.add(deleteBtn);

        add(top, BorderLayout.NORTH);


        model = new DefaultListModel<>();
        list = new JList<>(model);

        list.setBackground(new Color(30, 30, 50));
        list.setForeground(Color.WHITE);
        list.setFont(new Font("Segoe UI", Font.PLAIN, 14));


        preview = new JTextArea();
        preview.setLineWrap(true);
        preview.setWrapStyleWord(true);

        preview.setBackground(new Color(45, 45, 70));
        preview.setForeground(Color.WHITE);
        preview.setCaretColor(Color.WHITE);
        preview.setFont(new Font("Segoe UI", Font.PLAIN, 15));


        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(list),
                new JScrollPane(preview)
        );

        split.setDividerLocation(250);
        add(split, BorderLayout.CENTER);


        list.addListSelectionListener(e -> {
            int i = list.getSelectedIndex();
            if (i != -1) {

                String encrypted = notes.get(i).content;

                if (encrypted.length() > 300) {
                    encrypted = encrypted.substring(0, 300) + "...";
                }

                preview.setText("🔐 ENCRYPTED DATA:\n\n" + encrypted);
            }
        });
    }


    private void styleButton(JButton b) {
        b.setBackground(new Color(124, 58, 237));
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Segoe UI", Font.BOLD, 13));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
    }



    public void setNotes(List<NoteRow> notes) {
        this.notes = notes;
        model.clear();

        for (NoteRow n : notes) {
            model.addElement(n.title);
        }
    }

    public int getSelectedIndex() {
        return list.getSelectedIndex();
    }

    public void setPreviewContent(String text, boolean encrypted) {
        preview.setText(text);
    }

    public void addDeleteListener(ActionListener l) {
        deleteBtn.addActionListener(l);
    }

    public void addDecryptListener(ActionListener l) {
        decryptBtn.addActionListener(l);
    }

    public void addBackListener(ActionListener l) {
        backBtn.addActionListener(l);
    }


    public static class NoteRow {
        public int id;
        public String title;
        public String content;

        public NoteRow(int id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }
    }
}