package com.dto.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserLogin")
public class UserLogin {
	@Id
	private int userLoginId;
	private String userLoginName;
	private String passcode;
	private String salt;
	private String userRole;
	
	public UserLogin() {
		super();
	}

	public UserLogin(int userLoginId, String userLoginName, String passcode, String salt, String userRole) {
		super();
		this.userLoginId = userLoginId;
		this.userLoginName = userLoginName;
		this.passcode = passcode;
		this.salt = salt;
		this.userRole = userRole;
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserLogin [userLoginId = " + userLoginId + ", userLoginName = " + userLoginName + ", passcode = " + passcode
				+ ", salt = " + salt + ", userRole = " + userRole + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(passcode, salt, userLoginId, userLoginName, userRole);
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
				&& userLoginId == other.userLoginId && Objects.equals(userLoginName, other.userLoginName)
				&& Objects.equals(userRole, other.userRole);
	}
	
}
