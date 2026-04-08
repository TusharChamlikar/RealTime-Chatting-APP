package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.websocket.OnlineUsers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/online")
public class OnlineController {
    @GetMapping
    public String getMethodName() {
        return OnlineUsers.users.toString();
    }
    
}
