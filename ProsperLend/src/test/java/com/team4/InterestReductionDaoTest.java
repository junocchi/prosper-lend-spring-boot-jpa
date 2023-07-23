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
import com.dto.entity.InterestDeduction;
import com.dto.entity.UserLogin;
import com.model.persistence.BusinessDao;
import com.model.persistence.InterestDeductionDao;
import com.model.persistence.UserLoginDao;




@ActiveProfiles("test")
@SpringBootTest


class InterestReductionDaoTest {
	
	
	@Autowired
	private InterestDeductionDao dao;
	

	@Autowired
	private UserLoginDao dao2;
	
	
	
	
	@Test
    @DisplayName("Test for getting all Interest Deductions")
    public void ReturnAllDeductionsTests01() {
        List<InterestDeduction> deductionsList = dao.findAll();
        System.out.print(deductionsList.toString());
        assertNotNull(deductionsList);
        
        
    }
	
	
	@Test
    @DisplayName("Test for getting Interest Deductionby ID")
    public void ReturnDeductionsByIDTest() {
		InterestDeduction deductions = dao.findById(1).orElse(null);
        assertNotNull(deductions);
        
    }
	
	
	@Test
    @DisplayName("Test for getting Deductions by ID that doesn't exist")
    public void ReturnDeductionsByIDTest02() {
		InterestDeduction deductions = dao.findById(888).orElse(null);
        assertNull(deductions);
        
    }
	
	
	   @Test
	   @DisplayName("Test if Deductions is added sucessfully")
	   public void AddDeductionTest() {
	  
	   String item = "Empowering Women Reward";
	   double amount = 1;
	   
		    
	   int result = dao.addDeduction(item,amount);

			  
		    assertEquals(1, result);
		  }
	   
	   
	   

	   @Test
	   @DisplayName("Test if Deduction is deleted sucessfully")
	   public void DeleteDeductionTest() {   
	   dao.deleteById(4);
	   InterestDeduction deduction = dao.findById(4).orElse(null);
	   assertNull(deduction);
	  
	   
	   }
	   
	   
	   @Test
	   @DisplayName("Test if Business is updated sucessfully")
	   public void UpdateBusinessTest() { 
		   
	   int deductionId = 2;
	   double newAmount = 2;
	   
	   
	   int result = dao.updateDeductionAmountById(deductionId, newAmount);
	    
	    
		   assertEquals(1, result);
		   
		   
		   
	   }
			
	   
}
