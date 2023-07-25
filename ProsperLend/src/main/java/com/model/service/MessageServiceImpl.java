package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Message;
import com.model.persistence.MessageDao;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;

	// As admin we can
	@Override
	public Message searchMessageById(int messageId) {
		Message message = messageDao.findById(messageId).orElse(null);
		return message;
	}

	@Override
	public List<Message> getAllMessages() {
		return messageDao.findAll();
	}

	@Override
	public boolean insertNewMessage(Message message) {
		try {
		if (messageDao.insertMessage(message.getMessageId(), message.getUserEmail(), message.getUserName(), message.getMessage())>0)
			
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
		return false;
	}
	


}
