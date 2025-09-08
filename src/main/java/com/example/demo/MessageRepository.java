package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // Här kan man lägga till egna quely+metoder om man vill
    // List<Message> findByAuthor(String author);
}
