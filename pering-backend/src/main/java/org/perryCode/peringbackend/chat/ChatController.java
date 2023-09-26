package org.perryCode.peringbackend.chat;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	//private Map<String, Conversation> conversations =  new HashMap<String, Conversation>();
	
	
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
	/*
	@MessageMapping("/room")
	public void sendSpecific(@Payload ChatMessage chatMessage, Principal user
			,@Header("simpSessionId") String sessionId) throws Exception{
		
		
		System.out.println(sessionId);
		//System.out.println(user.getName());
		System.out.println(chatMessage.getReceiver());
		System.out.println(chatMessage.getSender());
		
		simpMessagingTemplate.convertAndSendToUser(chatMessage.getReceiver()
				, "/user/queue/specific-user"+sessionId, chatMessage);
		System.out.println(simpMessagingTemplate.toString()); 
		simpMessagingTemplate.convertAndSendToUser(chatMessage.getSender()
				, "/user/queue/specific-user", chatMessage);
		
	}
	*/
	/*
	@MessageMapping("/private.addUser")
	@SendTo("/topic/public/")
	public ChatMessage addUserPrivate(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccesor) {
		headerAccesor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
	
	@MessageMapping("/private-chat/")
	public ChatMessage handlePrivateMessage(@Payload ChatMessage chatMessage) {
		String senderUsername = chatMessage.getSender();
		String recipientUsername = chatMessage.getReceiver();
		
		String conversationKey = getConversationKey(senderUsername, recipientUsername);
		Conversation conversation = conversations.computeIfAbsent(
				conversationKey, key -> new Conversation(senderUsername, recipientUsername));

		conversation.getMessages().add(chatMessage);
		
		
		simpMessagingTemplate.convertAndSendToUser(senderUsername, "/queue/private", chatMessage);
		System.out.println(simpMessagingTemplate);
	    simpMessagingTemplate.convertAndSendToUser(recipientUsername, "/queue/private", chatMessage);
	    
	    return chatMessage;
	}
	
	private String getConversationKey(String user1, String user2) {
		System.out.println("entre aqui\n");
		System.out.println("entre"+ user1+ " aqui\n");
		System.out.println("entre"+ user2+ " aqui\n");
		List<String> sortedUsernames = Arrays.asList(user1,user2);
		System.out.println(sortedUsernames.get(0));
		Collections.sort(sortedUsernames);
		
		return sortedUsernames.get(0) + "-" + sortedUsernames.get(1);
	}*/
	
}
