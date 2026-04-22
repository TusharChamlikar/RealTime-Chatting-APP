package com.example.demo.controller;
import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageRepository messageRepository;
    @GetMapping
    public List<Message> getMessages(@RequestParam String sender, @RequestParam String receiver){
        return messageRepository.findBySenderAndReceiver(sender,receiver);
    }

    @GetMapping("/chat")
    public List<Message> getChat(@RequestParam String u1, @RequestParam String u2){
        return messageRepository.getChat(u1,u2);
    }
}
