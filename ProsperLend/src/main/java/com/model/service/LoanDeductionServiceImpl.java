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
    
    public LoanDeduction getLoanDeductionById(int loanDId) {
		LoanDeduction deduction = dao.findById(loanDId).orElse(null);
		return deduction;
    }

    
    
    public boolean insertLoanDeduction(LoanDeduction deduction) {
    	if (dao.addLoanDeduction(deduction.getDeduction().getInterestDeductionId(), deduction.getLoan().getLoanID())>0)
    	
    		return true;
    	else
    		return false;
    }
    
 
    public LoanDeduction deleteLoanDeduction(int loanDId) {
        LoanDeduction deduction = getLoanDeductionById(loanDId);
        if (deduction != null) {
            dao.delete(deduction);
        }
        return deduction;
    }
    
}
