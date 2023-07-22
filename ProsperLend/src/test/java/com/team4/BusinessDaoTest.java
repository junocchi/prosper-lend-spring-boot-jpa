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
import com.dto.entity.UserLogin;
import com.model.persistence.BusinessDao;
import com.model.persistence.LoanDao;
import com.model.persistence.TransactionDao;
import com.model.persistence.UserLoginDao;

import java.sql.Date;


@ActiveProfiles("test")
@SpringBootTest


class BusinessDaoTest {
	
	
	@Autowired
	private BusinessDao dao;
	

	@Autowired
	private UserLoginDao dao2;
	
	
	
	
	@Test
    @DisplayName("Test for getting all Business")
    public void ReturnAllLoansTests01() {
        List<Businesses> businessList = dao.findAll();
        System.out.print(businessList.toString());
        assertNotNull(businessList);
        
        
    }
	
	
	@Test
    @DisplayName("Test for getting Business by ID")
    public void ReturnBusinessByIDTest() {
		Businesses business = dao.findById(101).orElse(null);
        assertNotNull(business);
        
    }
	
	
	@Test
    @DisplayName("Test for getting Business by ID that doesn't exist")
    public void ReturnLoanByIDTest02() {
		Businesses business = dao.findById(888).orElse(null);
        assertNull(business);
        
    }
	
	
	   @Test
	   @DisplayName("Test if Business is added sucessfully")
	   public void AddLoanTest() {
	  
	   UserLogin userlogin = dao2.findById(1).orElse(null);
       int userLoginID = userlogin.getUserLoginId();
       String businessName = "My Buisness";
       String businessAdminEmail = "MyBuisness@SQL.com";
       int MerchantId = 4;
        
		    
	   int result = dao.addBusisness(userLoginID,businessName, businessAdminEmail, MerchantId);

			  
		    assertEquals(1, result);
		  }
	   
	   
	   

	   @Test
	   @DisplayName("Test if Business is deleted sucessfully")
	   public void DeleteBusinessTest() {   
	   dao.deleteById(104);
	   Businesses business = dao.findById(104).orElse(null);
	   assertNull(business);
	  
	   
	   }
	   
	   
	   @Test
	   @DisplayName("Test if Business is updated sucessfully")
	   public void UpdateBusinessTest() { 
		   
	   int businessId = 1002;
	   String newEmail = "Buisness@Buisness.com";
	   
	   
	   int result = dao.updateBusinessEmail(businessId, newEmail);
	    
	    
		   assertEquals(1, result);
		   
		   
		   
	   }
			
	   
}
