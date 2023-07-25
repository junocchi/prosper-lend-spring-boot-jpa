package com.dto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Messages")
public class Message {

	@Id
	private int messageId;
	private String userEmail;
	private String userName;
	private String message;

	public Message() {
		super();
	}

	public Message(int messageId, String userEmail, String userName, String message) {
		super();
		this.messageId = messageId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.message = message;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", userEmail=" + userEmail + ", userName=" + userName + ", message="
				+ message + "]";
	}
	
	

}
