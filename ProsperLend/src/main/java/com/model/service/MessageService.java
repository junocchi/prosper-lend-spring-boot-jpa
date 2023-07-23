package com.model.service;

import java.util.List;

import com.dto.entity.Messages;

public interface MessageService {

	// As admin we can
	public Messages searchMessageById(int messageId);
	public List<Messages> getAllMessages();
	
	// As admin and business user we can
	public boolean insertNewMessage(Messages message);
	
	boolean changeMessage(int messageId, String newMessage);
}
