package com.dto.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDetails")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userLoginId;
	private String userLoginName;
	private String passcode;
	private String businessName;   
    private String businessAdminEmail; 
    private Long merchantId; 
	
	
	
	public UserDetails() {
		super();
	}
	
	
	



	public UserDetails(String userLoginName, String passcode, String businessName, String businessAdminEmail,
			Long merchantId) {
		super();
		
		this.userLoginName = userLoginName;
		this.passcode = passcode;
		this.businessName = businessName;
		this.businessAdminEmail = businessAdminEmail;
		this.merchantId = merchantId;
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



	public String getBusinessName() {
		return businessName;
	}



	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}



	public String getBusinessAdminEmail() {
		return businessAdminEmail;
	}



	public void setBusinessAdminEmail(String businessAdminEmail) {
		this.businessAdminEmail = businessAdminEmail;
	}



	public Long getMerchantId() {
		return merchantId;
	}



	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	
	
	

}