package org.perryCode.peringbackend.chat;

import java.util.ArrayList;
import java.util.List;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Conversation {
	
	private String user1;
	private String user2;
	private List<ChatMessage> messages = new ArrayList<ChatMessage>();
	
	Conversation(String user1, String user2){
		this.user1 = user1;
		this.user2 = user2;
	}
	
}
