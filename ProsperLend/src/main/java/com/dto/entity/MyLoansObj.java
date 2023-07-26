package com.dto.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class MyLoansObj {
	private int loanId;
	private int loanCount;
	private Date loanDate;
	private String time;
	private String status;
	private BigDecimal borrowAmount;
	private BigDecimal repayAmount;
	private BigDecimal balance;
	private double deduction;
	private double interest;
	
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getLoanCount() {
		return loanCount;
	}
	public void setLoanCount(int loanCount) {
		this.loanCount = loanCount;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getBorrowAmount() {
		return borrowAmount;
	}
	public void setBorrowAmount(BigDecimal borrowAmount) {
		this.borrowAmount = borrowAmount;
	}
	public BigDecimal getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(BigDecimal repayAmount) {
		this.repayAmount = repayAmount;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public double getDeduction() {
		return deduction;
	}
	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	@Override
	public String toString() {
		return "myLoansObj [loanCount = " + loanCount + ", loanDate = " + loanDate + ", time = " + time + ", status = " + status
				+ ", borrowAmount = " + borrowAmount + ", repayAmount = " + repayAmount + ", balance = " + balance
				+ ", deduction = " + deduction + ", interest = " + interest + "]";
	}
}