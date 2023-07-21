package com.dto.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.dto.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "Loans")


public class Loans implements Serializable {
	
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="loanID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int loanID;
	
	
	@Column(name="loanStatus")
	String loanStatus;
	
	@Column(name="amount")
	Double amount;
	
	
	@Column(name="interest")
	Double interest;
	
    @OneToOne(mappedBy = "loan")
	private Business business;
	
	@Column(name="loanDate")
	Date loanDate;
	
    @OneToMany
	private List<Transaction> transactionList;
    
	
	
	public Loans() {
		super();
	}
	public Loans(int loanID, String loanStatus, Double amount, Double interest, Business business, Date loanDate,
			List<Transaction> transactionList) {
		super();
		this.loanID = loanID;
		this.loanStatus = loanStatus;
		this.amount = amount;
		this.interest = interest;
		this.business = business;
		this.loanDate = loanDate;
		this.transactionList = transactionList;
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
	
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public List<Transaction> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	
	
	
}


