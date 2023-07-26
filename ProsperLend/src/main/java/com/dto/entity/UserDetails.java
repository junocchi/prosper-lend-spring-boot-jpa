package com.dto.entity;


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
	private String salt;
	private String businessName;   
    private String businessAdminEmail; 
    private Long merchantId;
    private String image;
    
	public UserDetails() {
		super();
	}

	public UserDetails(int userLoginId, String userLoginName, String passcode, String salt, String businessName,
			String businessAdminEmail, Long merchantId, String image) {
		super();
		this.userLoginId = userLoginId;
		this.userLoginName = userLoginName;
		this.passcode = passcode;
		this.salt = salt;
		this.businessName = businessName;
		this.businessAdminEmail = businessAdminEmail;
		this.merchantId = merchantId;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "UserDetails [userLoginId = " + userLoginId + ", userLoginName = " + userLoginName + ", passcode = " + passcode
				+ ", salt = " + salt + ", businessName = " + businessName + ", businessAdminEmail = " + businessAdminEmail
				+ ", merchantId = " + merchantId + ", image = " + image + "]";
	}
	
	

}