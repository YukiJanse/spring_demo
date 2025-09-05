package com.example.demo;

public class Message {
    private String text;
    private String author;

    public Message(String text, String author) {
        this.text = text;
        this.author = author;
    }

    // Getter: use it when Spring converts JSON
    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}
