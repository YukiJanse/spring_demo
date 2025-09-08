package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Message> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
    }

    @PostMapping
    public Message add(@RequestBody Message message) {
        return repository.save(message);
    }

    @PutMapping("/{id}")
    public Message update(@PathVariable long id, @RequestBody Message update) {
        Message message = repository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
        message.setText(update.getText());
        message.setAuthor(update.getAuthor());
        return repository.save(update);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }

}
