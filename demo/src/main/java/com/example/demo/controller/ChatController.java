package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import com.example.demo.model.Message;

import java.time.LocalDateTime;
import com.example.demo.repository.MessageRepository;
import com.example.demo.websocket.OnlineUsers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;
    private final MessageRepository messageRepository;

    @MessageMapping("/private")
    public void sendPrivateMessage(Message chatMessage){
        if ("JOIN".equals(chatMessage.getType())) {
            OnlineUsers.users.add(chatMessage.getSender());
            return; // no need to process further
        }
        Message message = new Message();
        message.setSender(chatMessage.getSender());
        message.setReceiver(chatMessage.getReceiver());
        message.setContent(chatMessage.getContent());
        message.setTimeStamp(LocalDateTime.now());
        messageRepository.save(message);
        messagingTemplate.convertAndSend("/topic/"+chatMessage.getReceiver(),message);
    }
}
