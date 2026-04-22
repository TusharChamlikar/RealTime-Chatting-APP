package com.example.demo.repository;
import com.example.demo.model.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long>{
    List<Message> findBySenderAndReceiver(String sender,String receiver);
    @Query("SELECT m FROM Message m WHERE" +"(m.sender = :u1 AND m.receiver = :u2) OR "+"(m.sender =:u2 AND m.receiver = :u1) " + "ORDER BY m.timestamp ASC")
    List<Message> getChat(String u1, String u2);
}