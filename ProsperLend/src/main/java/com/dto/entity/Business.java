package com.dto.entity;

import javax.persistence.*;

@Entity
@Table(name = "Businesses")
public class Business {

    @Id
    @Column(name = "businessId")
    private int businessId;

    @JoinColumn(name = "userLoginId")
    @OneToOne
    private UserLogin userLoginId;

    @Column(name = "businessName")
    private String businessName;

    @Column(name = "businessAdminEmail")
    private String businessAdminEmail;

    @Column(name = "merchantId")
    private Long merchantId;

	public Business(int businessId, UserLogin userLoginId, String businessName, String businessAdminEmail,
			Long merchantId) {
		super();
		this.businessId = businessId;
		this.userLoginId = userLoginId;
		this.businessName = businessName;
		this.businessAdminEmail = businessAdminEmail;
		this.merchantId = merchantId;
	}

	public Business() {
		super();
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public UserLogin getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(UserLogin userLoginId) {
		this.userLoginId = userLoginId;
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
		return "Business [businessId=" + businessId + ", userLoginId=" + userLoginId + ", businessName=" + businessName
				+ ", businessAdminEmail=" + businessAdminEmail + ", merchantId=" + merchantId + "]";
	}


}