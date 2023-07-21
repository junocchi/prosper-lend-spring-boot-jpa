package com.dto.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "loanDeductions")
@IdClass(LoanDeduction.class)
public class LoanDeduction  implements Serializable {

	@Id
    @JoinColumn(name = "loanId")
    private int loanId;

    @Id
    @JoinColumn(name = "interestDeductionId")
    private int interestDeductionId;

	public LoanDeduction(int loanId, int interestDeductionId) {
		super();
		this.loanId = loanId;
		this.interestDeductionId = interestDeductionId;
	}

	public LoanDeduction() {
		super();
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
		return "LoanDeduction [loanId=" + loanId + ", interestDeductionId=" + interestDeductionId + "]";
	}
    
    
    
    
    
    
}