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
import javax.persistence.Table;


@Entity
@Table(name = "Transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	 @ManyToOne
	 private Loans loan;
	 
	 
  
	private Double amount;
	
	private Date transactionDate;
	

	public Transaction() {
		super();
	}

	public Transaction(int transactionId, Loans loan, Double amount, Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.loan = loan;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public Loans getLoan() {
		return loan;
	}

	public void setLoan(Loans loan) {
		this.loan = loan;
	}

}
