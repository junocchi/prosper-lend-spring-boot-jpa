package com.team4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;

import com.dto.entity.Loans;
import com.dto.entity.Transaction;

import com.model.persistence.LoanDao;
import com.model.persistence.TransactionDao;





@ActiveProfiles("test")
@SpringBootTest


class TransactionDaoTest {
	
	
	@Autowired
	private TransactionDao dao;
	
	@Autowired
	private LoanDao dao2;
	
	
	
	
	@Test
    @DisplayName("Test for getting all Transaction")
    public void ReturnAllTransactionTests01() {
        List<Transaction> transactionsList = dao.findAll();
        System.out.print(transactionsList.toString());
        assertNotNull(transactionsList);
        
        
    }
	
	
	@Test
    @DisplayName("Test for getting Business by ID")
    public void ReturntransactionByIDTest() {
		Transaction transaction = dao.findById(1).orElse(null);
        assertNotNull(transaction);
        
    }
	
	
	@Test
    @DisplayName("Test for getting transaction by ID that doesn't exist")
    public void ReturntransactionByIDTest02() {
		Transaction transaction = dao.findById(888).orElse(null);
        assertNull(transaction);
        
    }
	
	
	   @Test
	   @DisplayName("Test if Transaction is added sucessfully")
	   public void AddTransactionTest() {
	  
	   Loans loan = dao2.findById(1).orElse(null);
       int loanID = loan.getLoanID();
       double amount = 1234;
       long millis=System.currentTimeMillis();  
       Date transactionDate=new java.sql.Date(millis);
        
		    
	   int result = dao.addTransaction(loanID, amount, transactionDate);

			  
		    assertEquals(1, result);
		  }
	   
	   
	   

	   @Test
	   @DisplayName("Test if Transaction is deleted sucessfully")
	   public void DeleteTransactionTest() {   
	   dao.deleteById(3);
	   Transaction business = dao.findById(3).orElse(null);
	   assertNull(business);
	  
	   
	   }
	   
	   
	   @Test
	   @DisplayName("Test if Transaction is updated sucessfully")
	   public void UpdateTransactionTest() { 
		   
	   int transactionID = 2;
	   double amount = 234567.4;
	   
	   
	   int result = dao.updateAmount(transactionID, amount);
	    
	    
		   assertEquals(1, result);
		   
		   
		   
	   }
			
	   
}
