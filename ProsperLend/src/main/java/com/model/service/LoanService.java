package com.model.service;

import java.math.BigDecimal;
import java.util.List;

import com.dto.entity.Loans;

public interface LoanService {

	Loans getLoanById(int loanId);

	List<Loans> getAllLoans();

	boolean addLoan(Loans loan);

	boolean changeAmountInterest(int loanId, BigDecimal newAmount, BigDecimal newInterest);

	
	
	
	
}
