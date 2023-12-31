package com.team4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;

import com.dto.entity.InterestDeduction;
import com.dto.entity.Loans;

import com.dto.entity.UserDetails;

import com.model.persistence.LoanDao;

import com.model.persistence.UserDetailsDao;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@ActiveProfiles("test")
@SpringBootTest
class LoanDaoTest {

	@Autowired
	private LoanDao dao;

	@Autowired
	private UserDetailsDao dao2;

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
		Loans loan = dao.findById(1).orElse(null);
		assertNotNull(loan);
		
		System.out.println("By Id: " + loan);
	}

	@Test
	@DisplayName("Test for getting Loan by ID that doesn't exist")
	public void ReturnLoanByIDTest02() {
		Loans loan = dao.findById(14).orElse(null);

        assertNull(loan);
        
    }
//	
//	
//	   @Test
//	   @DisplayName("Test if Loan is added sucessfully")
//	   public void AddLoanTest() {
//	   UserDetails user = dao2.findById(1).orElse(null);
//	   System.out.println(user);
//	   long millis=System.currentTimeMillis();  
//       Double amount = 256742.4;
//       String loanStatus = "Pending";
//       Double interest = 0.6;
//       int userID = user.getUserLoginId();
//       Date loanDate=new java.sql.Date(millis); 
//       
//        
//       
//       
//		    
//	   int result = dao.addLoan(loanStatus, amount, interest, userID, loanDate);
//
//			  
//		    assertEquals(1, result);
//		  }
//	   
//	   
//	  
	   
	   
	   @Test
	   @DisplayName("Test if Loan by ID sucessfully")
	   public void GetLoanDebtTest() {   
	  int id = dao.getUserIdByLoanId(1);
	  System.out.println("id");
	  assertEquals(id,1);
	   
	   }
	   
	   

	   @Test
	   @DisplayName("Test to get User Debt sucessfully")
	   public void GetDebtTest() {   
	  BigDecimal debt = dao.getDebtByUserID(1);
	  System.out.println(debt);
	  assertNotNull(debt);
	   
	   }
	   
	   
	   
	   
	   
	   
//	   @Test
//	   @DisplayName("Test if Loan is updated sucessfully")
//	   public void UpdateLoanTest() { 
//		   
//	   int loanId = 2;
//	   BigDecimal amount;
//	   BigDecimal interest;
//	   
//	   int result = dao.updateLoansAmountById(loanId, amount, interest);
//	    
//	    
//		   assertEquals(1, result);
//		   
//		   
//		   
//	   }
//			
	   


	@Test
	@DisplayName("Test if Loan is added sucessfully")
	public void AddLoanTest() {
		UserDetails user = dao2.findById(1).orElse(null);
		
		System.out.println("Add Loan Test: " + user);
		
		Double amount = 256742.4;
		String loanStatus = "Pending";
		Double interest = 0.06;
		int userID = user.getUserLoginId();
		Date loanDate = Date.valueOf(LocalDate.now());

		int result = dao.addLoan(loanStatus, amount, interest, userID, loanDate);

		assertEquals(1, result);
	}
	

	@Test
	@DisplayName("Test if Loan is deleted sucessfully")
	public void DeleteLoanTest() {
		Loans loan = dao.findById(1).orElse(null);
		loan.setLoanID(999);
		System.out.println("Deleted: " + loan);
		
		dao.save(loan);
		assertNotNull(dao.findById(99).orElse(null));
		
		dao.deleteById(99);
		assertNull(dao.findById(99).orElse(null));
	}
}
	