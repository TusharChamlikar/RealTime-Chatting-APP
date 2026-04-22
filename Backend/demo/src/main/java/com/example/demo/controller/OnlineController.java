package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RedisService;
import com.example.demo.websocket.OnlineUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@RestController
@RequestMapping("/online")
public class OnlineController {
    @Autowired
    private  RedisService redisService;
    @GetMapping
    public Set<String> getMethodName() {
        
        return redisService.getUsers();
    }
    
}
