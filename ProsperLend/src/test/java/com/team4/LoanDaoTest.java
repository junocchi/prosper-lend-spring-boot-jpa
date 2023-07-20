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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ActiveProfiles;

import com.dto.entity.Loans;
import com.dto.entity.Transaction;

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
        assertNotNull(loansList);
        
    }
	
	
	@Test
    @DisplayName("Test for getting Loan by ID")
    public void ReturnLoanByIDTest() {
        Optional<Loans> loan = dao.findById(1);
        assertNotNull(loan);
        
    }
	
	
	@Test
    @DisplayName("Test for getting Loan by ID that doesn't exist")
    public void ReturnLoanByIDTest02() {
        Optional<Loans> loan = dao.findById(999);
        assertNull(loan);
        
    }
	
	
	   @Test
	   @DisplayName("Test if Loan is added sucessfully")
	   public void AddLocation01() {
	   List <Transaction> transactions = new ArrayList <Transaction>();
	   Optional<Transaction> transaction = dao2.findById(1);
	   if(transaction.isPresent()){
		   transactions.add(transaction.get());
		}
	   long millis=System.currentTimeMillis();  
       int loanID = 1021;
       Double amount = 256742.4;
       Double interest = 0.6;
       int businessID = 101;
       Date date=new java.sql.Date(millis);  
		    
		    int result = dao.addLoan(loanID, amount, interest, businessID, date, transactions);

			  
		    assertEquals(1, result);
		  }
	   
	
	
	

}
