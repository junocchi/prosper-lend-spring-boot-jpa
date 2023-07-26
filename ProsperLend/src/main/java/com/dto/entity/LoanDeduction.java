package com.dto.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "loanDeductions")
public class LoanDeduction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int loanDeductionID;
	@ManyToOne
	private Loans loan;
	@ManyToOne
	private InterestDeduction deduction;

	public LoanDeduction() {
		super();
	}

	public Loans getLoan() {
		return loan;
	}

	public void setLoan(Loans loan) {
		this.loan = loan;
	}

	public InterestDeduction getDeduction() {
		return deduction;
	}

	public void setDeduction(InterestDeduction deduction) {
		this.deduction = deduction;
	}

	public int getLoanDeductionId() {
		return loanDeductionID;
	}

	public void setLoanDeductionId(int loanDeductionId) {
		this.loanDeductionID = loanDeductionId;
	}

	@Override
	public String toString() {
		return "LoanDeduction [loanDeductionID = " + loanDeductionID + ", loan = " + loan + ", deduction = " + deduction
				+ "]";
	}
	
}
