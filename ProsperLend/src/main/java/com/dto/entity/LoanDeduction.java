package com.dto.entity;

import javax.persistence.*;

@Entity
@Table(name = "loanDeductions")
public class LoanDeduction {
 
    @Id
    private int loanDeductionId;
    @JoinColumn(name = "loanId")
    private int loanId;
    @JoinColumn(name = "interestDeductionId")
    private int interestDeductionId;
    
	public LoanDeduction(int loanDeductionId, int loanId, int interestDeductionId) {
		super();
		this.loanDeductionId = loanDeductionId;
		this.loanId = loanId;
		this.interestDeductionId = interestDeductionId;
	}
	
	public LoanDeduction() {
		super();
	}

	public int getLoanDeductionId() {
		return loanDeductionId;
	}
	public void setLoanDeductionId(int loanDeductionId) {
		this.loanDeductionId = loanDeductionId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getInterestDeductionId() {
		return interestDeductionId;
	}
	public void setInterestDeductionId(int interestDeductionId) {
		this.interestDeductionId = interestDeductionId;
	}

	@Override
	public String toString() {
		return "LoanDeduction [loanDeductionId = " + loanDeductionId + ", loanId = " + loanId + ", interestDeductionId = "
				+ interestDeductionId + "]";
	}
}