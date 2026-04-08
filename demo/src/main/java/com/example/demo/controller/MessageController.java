package com.example.demo.controller;
import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageRepository messageRepository;

    @GetMapping
    public List<Message> getMessages(@RequestParam String sender, @RequestParam String receiver){
        return messageRepository.findBySenderAndReceiver(sender,receiver);
    }
}
