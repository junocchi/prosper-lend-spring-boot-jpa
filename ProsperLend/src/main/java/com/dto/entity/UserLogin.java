package com.dto.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserLogin")
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userLoginId;
	private String userLoginName;
	private String passcode;
	private String salt;
	
	
	public UserLogin() {
		super();
	}

	public UserLogin(String userLoginName, String passcode) {
		super();
		this.userLoginName = userLoginName;
		this.passcode = passcode;
		
		
	}

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	
	@Override
	public String toString() {
		return "UserLogin [userLoginId = " + userLoginId + ", userLoginName = " + userLoginName + ", passcode = " + passcode
				+ ", salt = " + salt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(passcode, salt, userLoginId, userLoginName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		return Objects.equals(passcode, other.passcode) && Objects.equals(salt, other.salt)
				&& userLoginId == other.userLoginId && Objects.equals(userLoginName, other.userLoginName);
				
	}
	
}
