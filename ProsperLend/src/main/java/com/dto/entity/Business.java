package com.dto.entity;

import javax.persistence.*;

@Entity
@Table(name = "Businesses")
public class Business {

    @Id
    @Column(name = "businessID")
    private int businessId;

    @JoinColumn(name = "userLoginId")
    private int userLoginId;

    @Column(name = "businessName")
    private String businessName;

    @Column(name = "businessAdminEmail")
    private String businessAdminEmail;

    @Column(name = "merchantId")
    private Long merchantId;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "loanID")
    private Loans loan;


	public Business(int businessId, int userLoginId, String businessName, String businessAdminEmail,
			Long merchantId,Loans loan) {
		super();
		this.businessId = businessId;
		this.userLoginId = userLoginId;
		this.businessName = businessName;
		this.businessAdminEmail = businessAdminEmail;
		this.merchantId = merchantId;
		this.loan.setBusiness(this);
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

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
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
	
	
	

	public Loans getLoan() {
		return loan;
	}

	public void setLoan(Loans loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", userLoginId=" + userLoginId + ", businessName=" + businessName
				+ ", businessAdminEmail=" + businessAdminEmail + ", merchantId=" + merchantId + "]";
	}




 
}