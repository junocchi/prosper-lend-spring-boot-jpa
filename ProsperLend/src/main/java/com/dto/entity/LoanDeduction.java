package com.dto.entity;



import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "loanDeductions")

public class LoanDeduction {
	
	@Id
	private int loanDeductionID;
	
	
   @ManyToOne
   private Loans loan;
	
   @ManyToOne
   private InterestDeduction deduction;

	public LoanDeduction(Loans loan, InterestDeduction deduction) {
		super();
		this.loan = loan;
		this.deduction = deduction;
	}

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
	
	
    
    
    
    
    
}