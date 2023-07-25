package com.dto.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.dto.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "Loans")


public class Loans {
	


	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	
	@OneToOne
	private UserDetails user;
	

	private int loanID;
	private String loanStatus;
	private Double amount;
	private Double interest;
	private int businessID;
	private Date loanDate;

	
   
	
	
	public Loans() {
		super();
	}
	public Loans(int loanID, String loanStatus, Double amount, Double interest, UserDetails user, Date loanDate) {
		super();
		this.loanID = loanID;
		this.loanStatus = loanStatus;
		this.amount = amount;
		this.interest = interest;
		this.loanDate = loanDate;
		this.user = user;
		
	}
	
	
	
	
	public int getLoanID() {
		return loanID;
	}
	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}
	
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	

	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	
	public int getBusinessID() {
		return businessID;
	}
	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}


	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	
	
	
}


