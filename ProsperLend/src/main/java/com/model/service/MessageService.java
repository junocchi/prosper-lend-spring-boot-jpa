package com.model.service;

import java.util.List;

import com.dto.entity.Message;

public interface MessageService {

	// As admin we can
	public Message searchMessageById(int messageId);
	public List<Message> getAllMessages();
	
	// As admin and business user we can
	public Message insertNewMessage(Message message);
}
