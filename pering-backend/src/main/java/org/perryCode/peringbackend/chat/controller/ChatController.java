package org.perryCode.peringbackend.chat.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.perryCode.peringbackend.chat.entity.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.websocket.server.PathParam;



@Controller
public class ChatController {
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccesor) {
		// Add username in web socket session
		headerAccesor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
	
	@MessageMapping("/chat.sendPrivate")
	public void sendPrivateMessage(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor sha) {
		String message = chatMessage.getContent();
		System.out.println(message);
		System.out.println(sha.getUser().getName());
		System.out.println(chatMessage.getSender());
		System.out.println(chatMessage.getReceiver());
		
		simpMessagingTemplate.convertAndSendToUser(chatMessage.getReceiver(), "/queue/messages", chatMessage);
		
	}
	
	
}
