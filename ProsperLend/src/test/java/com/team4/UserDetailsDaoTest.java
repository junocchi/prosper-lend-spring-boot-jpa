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

import com.dto.entity.UserDetails;
import com.dto.entity.UserLogin;

import com.dto.entity.UserLogin;
import com.model.persistence.BusinessDao;
import com.model.persistence.UserDetailsDao;
import com.model.persistence.UserLoginDao;




@ActiveProfiles("test")
@SpringBootTest


class UserDetailsDaoTest {
	
	
	@Autowired
	private UserDetailsDao dao;
	

	
	
	
	@Test
    @DisplayName("Test for getting all UserLogin")
    public void ReturnAllUserLoginTests01() {
        List<UserDetails> userList = dao.findAll();
        System.out.print(userList.toString());
        assertNotNull(userList);
        
        
    }
	
	
	@Test
    @DisplayName("Test for getting UserLogin by ID")
    public void ReturnUserLoginByIDTest() {
		UserDetails Userlogin = dao.findById(1).orElse(null);
        assertNotNull(Userlogin);
        
    }
	
	
	@Test
    @DisplayName("Test for getting UserLogin by ID that doesn't exist")
    public void ReturnUserLoginByIDTest02() {
		UserDetails UserLogin = dao.findById(888).orElse(null);
        assertNull(UserLogin);
        
    }
	
	
	   @Test
	   @DisplayName("Test if UserLogin is added sucessfully")
	   public void AddUserLoginTest() {
	  
		   String userLoginName = "test";
		   String passcode = "passcode";
		   String businessName = "BName";
		   String email  = "Email@email.com";
		   long merchantId = 123442;
		   
		    
	   int result = dao.insertUserLoginData(userLoginName,passcode, businessName, email, merchantId);

			  
		    assertEquals(1, result);
		  }
	   
	   
	   

	   @Test
	   @DisplayName("Test if UserLogin is deleted sucessfully")
	   public void DeleteUserLoginTest() {   
	   dao.deleteById(4);
	   UserDetails UserLogin = dao.findById(4).orElse(null);
	   assertNull(UserLogin);
	  
	   
	   }
	   
	   
	   @Test
	   @DisplayName("Test if Password is updated sucessfully")
	   public void UpdatePasswordTest() { 
		   
	   int userLoginId = 2;
	   String newPassword = "1234";
	   
	   
	   int result = dao.updatePassword(newPassword , userLoginId);
	    
	    
		   assertEquals(1, result);
		   
		   
		   
	   }
			
	   
}
