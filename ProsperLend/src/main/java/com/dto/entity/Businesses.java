package com.dto.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Businesses")
public class Businesses {

    @Id
    private int businessId;
    
    @OneToOne
	private UserLogin userLogin;
    
    
    private String businessName;

   
    private String businessAdminEmail;

    
    private Long merchantId;
    


	public Businesses(int businessID, int userLoginId, String businessName, String businessAdminEmail,
			Long merchantId, UserLogin userLogin) {
		super();
		this.businessId = businessID;
		this.businessName = businessName;
		this.businessAdminEmail = businessAdminEmail;
		this.merchantId = merchantId;
		this.userLogin = userLogin;
	}

	public Businesses() {
		super();
	}
	
	



	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
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
	
	

	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", businessName=" + businessName
				+ ", businessAdminEmail=" + businessAdminEmail + ", merchantId=" + merchantId + "]";
	}




 
}