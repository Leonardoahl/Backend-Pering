package org.perryCode.peringbackend.chat.entity;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

public class UserInterceptor implements ChannelInterceptor {

	@SuppressWarnings("unchecked")
	@Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            Object raw = message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS);
            if (raw instanceof Map) {
                @SuppressWarnings("rawtypes")
				Object name = ((Map) raw).get("username");
                System.out.println(name);
                if (name instanceof ArrayList) {
                    accessor.setUser(new PrivateChatUser(((ArrayList<String>) name).get(0).toString()));
                    System.out.println("hola " + accessor.getUser().getName());
                }
            }
        }
        
        System.out.println(message);
        return message;
    }
	
}
