//package com.team4;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.springframework.test.context.ActiveProfiles;
//
//import com.dto.entity.InterestDeduction;
//import com.dto.entity.LoanDeduction;
//import com.dto.entity.Loans;
//import com.dto.entity.UserLogin;
//import com.model.persistence.BusinessDao;
//import com.model.persistence.InterestDeductionDao;
//import com.model.persistence.LoanDao;
//import com.model.persistence.LoanDeductionDao;
//import com.model.persistence.UserLoginDao;
//
//
//
//
//@ActiveProfiles("test")
//@SpringBootTest
//
//
//class LoanDeductionDaoTest {
//	
//	
//	@Autowired
//	private LoanDeductionDao dao;
//	
//	@Autowired
//	private LoanDao dao2;
//	
//	@Autowired
//	private InterestDeductionDao dao3;
//	
//	
//	
//	@Test
//    @DisplayName("Test for getting all Loan Deductions")
//    public void ReturnAllDeductionsTests01() {
//        List<LoanDeduction> loanDeductionList = dao.findAll();
//        System.out.print(loanDeductionList.toString());
//        assertNotNull(loanDeductionList);
//        
//        
//    }
//	
//	
//	@Test
//    @DisplayName("Test for getting Loan Deductionby ID")
//    public void ReturnDeductionsByIDTest() {
//		LoanDeduction deductions = dao.findById(1).orElse(null);
//        assertNotNull(deductions);
//        
//    }
//	
//	
//	@Test
//    @DisplayName("Test for getting Deductions by ID that doesn't exist")
//    public void ReturnDeductionsByIDTest02() {
//		LoanDeduction deductions = dao.findById(888).orElse(null);
//        assertNull(deductions);
//        
//    }
//	
//	
//	   @Test
//	   @DisplayName("Test if Deductions is added sucessfully")
//	   public void AddDeductionTest() {
//	  
//	   Loans l = dao2.findById(1).orElse(null);
//	   InterestDeduction d = dao3.findById(3).orElse(null);
//	   
//	   int loan = l.getLoanID();
//	   int deduction = d.getInterestDeductionId();
//	   
//		    
//	   int result = dao.addLoanDeduction(loan,deduction);
//
//			  
//		    assertEquals(1, result);
//		  }
//	   
//	   
//	   
//
//	   @Test
//	   @DisplayName("Test if Deduction is deleted sucessfully")
//	   public void DeleteDeductionTest() {   
//	   dao.deleteById(4);
//	   LoanDeduction deduction = dao.findById(4).orElse(null);
//	   assertNull(deduction);
//	  
//	   
//	   }
//	   
//	   
//	   
//	   
//}
