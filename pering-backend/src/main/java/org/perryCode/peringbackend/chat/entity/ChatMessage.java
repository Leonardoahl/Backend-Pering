package org.perryCode.peringbackend.chat.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
	private String content;
	private String sender;
	private String receiver;
	private MessageType type;
	
}
