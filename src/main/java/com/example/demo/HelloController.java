package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class HelloController {
    private List<Message> storedMessages = new ArrayList<Message>();
    private List<Message> messages = new ArrayList<Message>();

    @GetMapping("/messages")
    public List<Message> messages() {
        return messages;
    }

    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }
    @PostMapping("/add-message")
    public Message addMessageToStoredMessages(@RequestBody Message message) {
        storedMessages.add(message);
        return message; // return the saved message
    }

    @GetMapping("/all-messages")
    public List<Message> getAllMessages() {
        return storedMessages;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/time")
    public String time() {
        return "Current time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));

    }

    @GetMapping("/json")
    public Message json() {
        return new Message("Hello, JSON!", "Spring Boot");
    }

    @GetMapping("/random-message")
    public Message randomMessage() {
        List<Message> messages = List.of(
                new Message("Hello!", "System"),
                new Message("Welcome to Spring Boot", "Teacher"),
                new Message("Good luck with your studies!", "Assistant"));
        Random random = new Random();
        return messages.get(random.nextInt(messages.size()));
    }

}
