package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Businesses;
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
    
<<<<<<< HEAD
    public LoanDeduction getLoanDeductionById(int loanDId) {
		LoanDeduction deduction = dao.findById(loanDId).orElse(null);
		return deduction;
=======
    public LoanDeduction getLoanDeductionById(int loanDeductionId ) {
		return dao.findById(loanDeductionId).orElse(null);
>>>>>>> b0ac2b20f7375da63951e65d618c2a5fedef0370
    }

    
    
    public boolean insertLoanDeduction(LoanDeduction deduction) {
<<<<<<< HEAD
    	if (dao.addLoanDeduction(deduction.getDeduction().getInterestDeductionId(), deduction.getLoan().getLoanID())>0)
    	
    		return true;
    	else
    		return false;
=======
    	try {
    	if (dao.insertDeduction(deduction.getLoanDeductionId(), deduction.getLoanId(), deduction.getInterestDeductionId())>0)
    		return true;
    	}
    	catch(Exception ex) {
    		return false;
    	}
    	return false;
>>>>>>> b0ac2b20f7375da63951e65d618c2a5fedef0370
    }
    	
    			
    			
 
<<<<<<< HEAD
    public LoanDeduction deleteLoanDeduction(int loanDId) {
        LoanDeduction deduction = getLoanDeductionById(loanDId);
=======
    public boolean deleteLoanDeduction(int loanDeductionId) {
        LoanDeduction deduction = getLoanDeductionById(loanDeductionId);
>>>>>>> b0ac2b20f7375da63951e65d618c2a5fedef0370
        if (deduction != null) {
            dao.deleteById(loanDeductionId);
			return true;
		}
		return false;
	}


    
    
}
