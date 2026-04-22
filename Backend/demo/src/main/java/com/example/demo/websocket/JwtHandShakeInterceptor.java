package com.example.demo.websocket;

import org.springframework.http.server.*;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.example.demo.security.JwtUtil;

import java.util.Map;

@Component
public class JwtHandShakeInterceptor implements HandshakeInterceptor {

    private final JwtUtil jwtUtil;

    public JwtHandShakeInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request,
                                   ServerHttpResponse response,
                                   org.springframework.web.socket.WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) {

        String query = request.getURI().getQuery(); // 🔥 read from URL

        if (query != null && query.startsWith("token=")) {
            String token = query.substring(6);

            try {
                String username = jwtUtil.extractUsername(token);

                if (jwtUtil.validateToken(token)) {
                    attributes.put("username", username);
                }
            } catch (Exception e) {
                return false; // ❌ reject invalid token
            }
        }

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request,
                               ServerHttpResponse response,
                               WebSocketHandler wsHandler,
                               Exception exception) {}
}