package com.model.service;

import java.util.List;

import com.dto.entity.LoanDeduction;

public interface LoanDeductionService {

	public List<LoanDeduction> getAllLoanDeductions();
	public LoanDeduction getLoanDeductionById(int loanDeductionId);
	public boolean insertLoanDeduction(LoanDeduction deduction);
	public boolean deleteLoanDeduction(int loanDeductionId);
}
