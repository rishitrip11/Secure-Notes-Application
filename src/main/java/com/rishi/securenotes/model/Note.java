package com.rishi.securenotes.model;

public class Note {

    private int id;
    private String title;
    private String content;
    private String username;

    public Note(int id, String title, String content, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getUsername() { return username; }
}