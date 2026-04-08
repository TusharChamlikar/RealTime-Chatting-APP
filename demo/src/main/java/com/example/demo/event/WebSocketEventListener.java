package com.example.demo.event;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    @EventListener
    public void handleConnect(SessionConnectEvent event) {
        System.out.println("User connected");
    }

    @EventListener
    public void handleDisconnect(SessionDisconnectEvent event) {
        System.out.println("User disconnected");
    }
}