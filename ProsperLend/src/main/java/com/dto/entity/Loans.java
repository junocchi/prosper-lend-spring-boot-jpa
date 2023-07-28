package com.dto.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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


public class Loans implements Serializable{
	


	
	

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanID;
	private String loanStatus;
	private BigDecimal amount;
	private BigDecimal currentDebt;
	private BigDecimal interest;
	private Date loanDate;
    private int userLoginId;


//	@OneToOne
//	private UserDetails user;
	
	
	
	
	public Loans() {
		super();
	
		
	}


	public Loans(String loanStatus, BigDecimal amount, BigDecimal currentDebt, BigDecimal interest,
		Date loanDate, int userLoginId) {
	super();
	this.loanStatus = loanStatus;
	this.amount = amount;
	this.currentDebt = currentDebt;
	this.interest = interest;
	this.loanDate = loanDate;
	this.userLoginId = userLoginId;
}


	public int getLoanID() {
		return loanID;
	}


	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}


	public String getLoanStatus() {
		return loanStatus;
	}


	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public BigDecimal getCurrentDebt() {
		return currentDebt;
	}


	public void setCurrentDebt(BigDecimal currentDebt) {
		this.currentDebt = currentDebt;
	}


	public BigDecimal getInterest() {
		return interest;
	}


	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}


	public Date getLoanDate() {
		return loanDate;
	}


	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}


	


	public int getUserLoginId() {
		// TODO Auto-generated method stub
		return userLoginId;
	}
	
	
	public void setUserLoginId(int userLoginId) {
		// TODO Auto-generated method stub
		this.userLoginId = userLoginId;
	}


//	public int getUserLoginID() {
//		return userLoginID;
//	}
//
//
//	public void setUserLoginID(int userLoginID) {
//		this.userLoginID = userLoginID;
//	}
	
	
	
	
}