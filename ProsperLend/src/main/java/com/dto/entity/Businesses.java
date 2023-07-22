package com.dto.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Businesses")
public class Businesses {

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
    
    @OneToMany
	private List<Loans> loanList=new ArrayList<Loans>(); 


	public Businesses(int businessID, int userLoginId, String businessName, String businessAdminEmail,
			Long merchantId) {
		super();
		this.businessId = businessID;
		this.userLoginId = userLoginId;
		this.businessName = businessName;
		this.businessAdminEmail = businessAdminEmail;
		this.merchantId = merchantId;
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
	
	

	public List<Loans> getLoanList() {
		return loanList;
	}

	public void setLoanList(List<Loans> loanList) {
		this.loanList = loanList;
	}

	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", userLoginId=" + userLoginId + ", businessName=" + businessName
				+ ", businessAdminEmail=" + businessAdminEmail + ", merchantId=" + merchantId + "]";
	}




 
}