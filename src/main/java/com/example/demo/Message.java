package com.example.demo;

public class Message {
    private static long counter =  1;
    private long id;
    private String text;
    private String author;

    public Message(String text, String author) {
        this.id = counter++;
        this.text = text;
        this.author = author;
    }

    // Getter: use it when Spring converts JSON
    public long getId() { return id; }
    public String getText() { return text; }
    public String getAuthor() { return author; }

    // Setter: valfritt om du vill kunna uppdatera via JSON
    public void setText(String text) { this.text = text; }
    public void setAuthor(String author) { this.author = author; }
}
