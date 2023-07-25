package com.dto.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transaction {

	@Id
	private int transactionId;
	private int loanId;
	private double amount;
	private Date transactionDate;

	public Transaction() {
		super();
	}

	public Transaction(int transactionId, int loanId, double amount, Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.loanId = loanId;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId = " + transactionId + ", loanId = " + loanId + ", amount = " + amount
				+ ", transactionDate = " + transactionDate + "]";
	}

	
}
