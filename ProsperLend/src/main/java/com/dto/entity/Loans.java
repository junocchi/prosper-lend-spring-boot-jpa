package com.dto.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "Loans")


public class Loans {
	
	

	
	@Id
	int loanID;
	Double amount;
	Double interest;
	int businessID;
	Date loanDate;
	
	
	
	public Loans() {
		super();
	}
	public Loans(int loanID, Double amount, Double interest, int businessID, Date loanDate,
			List<Transaction> transactionList) {
		super();
		this.loanID = loanID;
		this.amount = amount;
		this.interest = interest;
		this.businessID = businessID;
		this.loanDate = loanDate;
		this.transactionList = transactionList;
	}
	@OneToMany
	 private List<Transaction> transactionList = new ArrayList<Transaction>();
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
	public List<Transaction> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	
	
}