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

import com.dto.entity.Businesses;
import com.dto.entity.Loans;
import com.dto.entity.Transaction;
import com.model.persistence.BusinessDao;
import com.model.persistence.LoanDao;
import com.model.persistence.TransactionDao;

import java.sql.Date;


@ActiveProfiles("test")
@SpringBootTest
class LoanDaoTest {
	
	
	@Autowired
	private LoanDao dao;

	@Autowired
	private BusinessDao dao2;
	
	
	@Autowired
	private TransactionDao dao3;
	
	
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
		Loans loan = dao.findById(2).orElse(null);
        assertNotNull(loan);
        
    }
	
	
	@Test
    @DisplayName("Test for getting Loan by ID that doesn't exist")
    public void ReturnLoanByIDTest02() {
		Loans loan = dao.findById(14).orElse(null);
        assertNull(loan);
        
    }
	
	
	   @Test
	   @DisplayName("Test if Loan is added sucessfully")
	   public void AddLoanTest() {
	   Businesses business = dao2.findById(1).orElse(null);
	   System.out.println(business);
	   long millis=System.currentTimeMillis();  
       Double amount = 256742.4;
       String loanStatus = "Pending";
       Double interest = 0.6;
       int businessID = business.getBusinessId();
       Date loanDate=new java.sql.Date(millis); 
       
        
       
       
		    
	   int result = dao.addLoan(loanStatus, amount, interest, businessID, loanDate);

			  
		    assertEquals(1, result);
		  }
	   
	   
	   

	   @Test
	   @DisplayName("Test if Loan is deleted sucessfully")
	   public void DeleteLoanTest() {   
	   dao.deleteById(4);
	   Loans loan = dao.findById(4).orElse(null);
	   assertNull(loan);
	  
	   
	   }
	   
	   
	   @Test
	   @DisplayName("Test if Loan is updated sucessfully")
	   public void UpdateLoanTest() { 
		   
	   int loanId = 2;
	   double amount = 400.25;
	   double interest = 0.5;
	   
	   int result = dao.updateLoansAmountById(loanId, amount, interest);
	    
	    
		   assertEquals(1, result);
		   
		   
		   
	   }
			
	   
}
