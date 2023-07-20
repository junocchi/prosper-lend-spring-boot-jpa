package com.model.service;

import java.util.List;

import com.dto.entity.LoanDeduction;

public interface LoanDeductionService {

	public List<LoanDeduction> getAllLoanDeductions();
	public LoanDeduction getLoanDeductionById(int loanId, int interestDeductionId);
	public LoanDeduction insertLoanDeduction(LoanDeduction deduction);
	public LoanDeduction deleteLoanDeduction(int loanId, int interestDeductionId);
}
