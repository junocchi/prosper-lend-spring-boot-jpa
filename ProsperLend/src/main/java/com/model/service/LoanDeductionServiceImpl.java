package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Businesses;
import com.dto.entity.LoanDeduction;
import com.model.persistence.BusinessDao;
import com.model.persistence.LoanDeductionDao;

@Service
public class LoanDeductionServiceImpl {

    @Autowired
    private LoanDeductionDao dao;
    
    public List<LoanDeduction> getAllLoanDeductions() {
        return dao.findAll();
    }
    
    public LoanDeduction getLoanDeductionById(int loanId, int interestDeductionId) {
		LoanDeduction deduction = dao.findByLoanIdAndInterestDeductionId(loanId, interestDeductionId);
		return deduction;
    }

    
    
    public LoanDeduction insertLoanDeduction(LoanDeduction deduction) {
    	if (getLoanDeductionById(deduction.getInterestDeductionId(), deduction.getLoanId())==null)
    		return dao.save(deduction);
    	else
    		return null;
    }
    
 
    public LoanDeduction deleteLoanDeduction(int loanId, int interestDeductionId) {
        LoanDeduction deduction = getLoanDeductionById(loanId, interestDeductionId);
        if (deduction != null) {
            dao.delete(deduction);
        }
        return deduction;
    }
    
}
