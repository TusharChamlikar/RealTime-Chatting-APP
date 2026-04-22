package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import com.example.demo.model.Message;
import com.example.demo.service.RedisService;

import java.security.Principal;
import java.time.LocalDateTime;
import com.example.demo.repository.MessageRepository;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;
    private final MessageRepository messageRepository;
    private final RedisService redisService;

    
@MessageMapping("/private")
public void sendPrivateMessage(Message chatMessage, Principal principal) {

    if (principal == null) {
        throw new RuntimeException("Unauthorized");
    }

    String username = principal.getName(); // 🔥 real authenticated user

    if ("JOIN".equals(chatMessage.getType())) {
        redisService.addUser(username);
        return;
    }

    Message message = new Message();
    message.setSender(username); // 🔥 TRUST SERVER, NOT CLIENT
    message.setReceiver(chatMessage.getReceiver());
    message.setContent(chatMessage.getContent());
    message.setTimeStamp(LocalDateTime.now());

    messageRepository.save(message);

    messagingTemplate.convertAndSend(
        "/topic/" + chatMessage.getReceiver(),
        message
    );
}}
