//package com.dto.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table(name = "Businesses")
//public class Businesses {
//
//    @Id
//    private int businessId;
//
//    
//    @OneToOne
//	private UserLogin userLogin;
//    
//    
//
//    @JoinColumn(name = "userLoginId")
//    @OneToOne
//
//    @Column(name = "businessName")
//
//    private String businessName;
//
//   
//    private String businessAdminEmail;
//
//    
//    private Long merchantId; 
//    
//    int userLoginId;
//    
//
//
//
//	public Businesses(int userLoginId, String businessName, String businessAdminEmail,
//
//	public Business(int businessId, UserLogin userLoginId, String businessName, String businessAdminEmail)
// {
//		super();
//		
//		this.userLoginId = userLoginId;
//		this.businessName = businessName;
//		this.businessAdminEmail = businessAdminEmail;
//		this.merchantId = merchantId;
//		
//	}
//
//	public Businesses() {
//		super();
//	}
//	
//	
//
//
//
//	public int getBusinessId() {
//		return businessId;
//	}
//
//	public void setBusinessId(int businessId) {
//		this.businessId = businessId;
//	}
//
//<<<<<<< HEAD:ProsperLend/src/main/java/com/dto/entity/Businesses.java
//	
//
//	public UserLogin getUserLogin() {
//		return userLogin;
//	}
//
//	public void setUserLogin(UserLogin userLogin) {
//		this.userLogin = userLogin;
//	}
//
//	
//	
//	public int getUserLoginID() {
//		
//=======
//	public UserLogin getUserLoginId() {
//>>>>>>> b0ac2b20f7375da63951e65d618c2a5fedef0370:ProsperLend/src/main/java/com/dto/entity/Business.java
//		return userLoginId;
//	}
//
//	public void setUserLoginId(UserLogin userLoginId) {
//		this.userLoginId = userLoginId;
//	}
//	
//	
//	
//	
//	public String getBusinessName() {
//		return businessName;
//	}
//
//	public void setBusinessName(String businessName) {
//		this.businessName = businessName;
//	}
//
//	public String getBusinessAdminEmail() {
//		return businessAdminEmail;
//	}
//
//	public void setBusinessAdminEmail(String businessAdminEmail) {
//		this.businessAdminEmail = businessAdminEmail;
//	}
//
//	public Long getMerchantId() {
//		return merchantId;
//	}
//
//	public void setMerchantId(Long merchantId) {
//		this.merchantId = merchantId;
//	}
//	
//	
//	
//
//	@Override
//	public String toString() {
//		return "Business [businessId=" + businessId + ", businessName=" + businessName
//				+ ", businessAdminEmail=" + businessAdminEmail + ", merchantId=" + merchantId + "]";
//	}
//
//
//<<<<<<< HEAD:ProsperLend/src/main/java/com/dto/entity/Businesses.java
//
//
// 
//=======
//>>>>>>> b0ac2b20f7375da63951e65d618c2a5fedef0370:ProsperLend/src/main/java/com/dto/entity/Business.java
//}