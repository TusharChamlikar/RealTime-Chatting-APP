package com.example.demo.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository; // ✅ required import
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public Users saveUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
