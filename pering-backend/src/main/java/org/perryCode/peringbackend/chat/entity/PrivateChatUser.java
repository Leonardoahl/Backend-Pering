package org.perryCode.peringbackend.chat.entity;

import java.security.Principal;

public class PrivateChatUser  implements Principal{

	private String name;
	
	public PrivateChatUser(String name) {
		this.name = name;
	}
	
	@Override
	public	String getName() {
		return name;
	}
	
}
