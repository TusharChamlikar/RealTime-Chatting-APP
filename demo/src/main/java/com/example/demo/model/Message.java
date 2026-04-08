package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

@Entity
@Data
@Table(name= "messages")
public class Message{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sender;
    private String receiver;
    private String content;
    private LocalDateTime timestamp;
    private String type;
    public void setTimeStamp(LocalDateTime now) {
        this.timestamp = now;

    }
    public LocalDateTime getTimeStamp() {
        return timestamp;
    }

}