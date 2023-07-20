package com.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dto.entity.LoanDeduction;

public interface LoanDeductionDao extends JpaRepository <LoanDeduction, Integer>{

	LoanDeduction findByLoanIdAndInterestDeductionId(int loanId, int interestDeductionId);
	
	
}
