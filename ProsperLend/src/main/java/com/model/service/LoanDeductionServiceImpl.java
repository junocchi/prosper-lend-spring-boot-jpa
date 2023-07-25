package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Business;
import com.dto.entity.LoanDeduction;
import com.model.persistence.BusinessDao;
import com.model.persistence.LoanDeductionDao;

@Service
public class LoanDeductionServiceImpl implements LoanDeductionService{

    @Autowired
    private LoanDeductionDao dao;
    
    public List<LoanDeduction> getAllLoanDeductions() {
        return dao.findAll();
    }
    
    public LoanDeduction getLoanDeductionById(int loanDeductionId ) {
		return dao.findById(loanDeductionId).orElse(null);
    }

    
    
    public boolean insertLoanDeduction(LoanDeduction deduction) {
    	try {
    	if (dao.insertDeduction(deduction.getLoanDeductionId(), deduction.getLoanId(), deduction.getInterestDeductionId())>0)
    		return true;
    	}
    	catch(Exception ex) {
    		return false;
    	}
    	return false;
    }
    	
    			
    			
 
    public boolean deleteLoanDeduction(int loanDeductionId) {
        LoanDeduction deduction = getLoanDeductionById(loanDeductionId);
        if (deduction != null) {
            dao.deleteById(loanDeductionId);
			return true;
		}
		return false;
	}


    
    
}
