package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Messages;
import com.model.persistence.MessageDao;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;

	// As admin we can
	@Override
	public Messages searchMessageById(int messageId) {
		Messages message = messageDao.findById(messageId).orElse(null);
		return message;
	}

	@Override
	public List<Messages> getAllMessages() {
		return messageDao.findAll();
	}

	@Override

	public boolean insertNewMessage(Messages message) {
		try {
			if(messageDao.addMessage( 
					message.getUserEmail(), message.getUserName(),
					message.getMessage())>0)
				return true;
			}
			catch(Exception ex) {
				return false;
			}
			return false;
	}
	
	
	
	@Override
	public boolean changeMessage(int messageId, String newMessage) {
		
		if(messageDao.updateMessage(messageId, newMessage)>0)
			return true;
		else
			return false;

	}


	
}

