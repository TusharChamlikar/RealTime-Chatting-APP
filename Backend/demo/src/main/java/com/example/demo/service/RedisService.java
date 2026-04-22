package com.example.demo.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class RedisService {
    private static final String KEY = "onlineUsers";
    private final RedisTemplate<String,String> redisTemplate;

    public void addUser(String username){
        redisTemplate.opsForSet().add(KEY,username);
    }
    public Set<String> getUsers(){
        return redisTemplate.opsForSet().members(KEY);
    }
    public void removeUser(String username){
        redisTemplate.opsForSet().remove(KEY,username);
    }
}
