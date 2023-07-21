package com.team4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;
import com.dto.entity.Loans;


import com.model.persistence.LoanDao;
import com.model.persistence.TransactionDao;

import java.sql.Date;


@ActiveProfiles("test")
@SpringBootTest
class LoanDaoTest {
	
	
	@Autowired
	private LoanDao dao;
	@Autowired
	private TransactionDao dao2;
	
	
	
	@Test
    @DisplayName("Test for getting all Loans")
    public void ReturnAllLoansTests01() {
        List<Loans> loansList = dao.findAll();
        System.out.print(loansList.toString());
        assertNotNull(loansList);
        
        
    }
	
	
	@Test
    @DisplayName("Test for getting Loan by ID")
    public void ReturnLoanByIDTest() {
		Loans loan = dao.findById(1002).orElse(null);
        assertNotNull(loan);
        
    }
	
	
	@Test
    @DisplayName("Test for getting Loan by ID that doesn't exist")
    public void ReturnLoanByIDTest02() {
		Loans loan = dao.findById(1).orElse(null);
        assertNull(loan);
        
    }
	
	
	   @Test
	   @DisplayName("Test if Loan is added sucessfully")
	   public void AddLoanTest() {
	   long millis=System.currentTimeMillis();  
       int loanID = 1004;
       Double amount = 256742.4;
       String status = "Pending";
       Double interest = 0.6;
       Date date=new java.sql.Date(millis);  
		    
	   int result = dao.addLoan(loanID, status, amount, interest, date);

			  
		    assertEquals(1, result);
		  }
	   
	   
	   

	   @Test
	   @DisplayName("Test if Loan is deleted sucessfully")
	   public void DeleteLoanTest() {   
	   dao.deleteById(1004);
	   Loans loan = dao.findById(1).orElse(null);
	   assertNull(loan);
	  
	   
	   }
	   
	   
	   @Test
	   @DisplayName("Test if Loan is updated sucessfully")
	   public void UpdateLoanTest() { 
		   
	   int loanId = 1002;
	   double amount = 400.25;
	   double interest = 0.5;
	   
	   int result = dao.updateSalaryAmountById(loanId, amount, interest);
	    
	    
		   assertEquals(1, result);
		   
		   
		   
	   }
			
	   
}
