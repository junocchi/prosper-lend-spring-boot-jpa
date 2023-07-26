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
//import com.dto.entity.UserLogin;
//
//import com.dto.entity.UserLogin;
//import com.model.persistence.BusinessDao;
//
//import com.model.persistence.UserLoginDao;
//
//
//
//
//@ActiveProfiles("test")
//@SpringBootTest
//
//
//class UserLoginDaoTest {
//	
//	
//	@Autowired
//	private UserLoginDao dao;
//	
//
//	
//	
//	
//	@Test
//    @DisplayName("Test for getting all UserLogin")
//    public void ReturnAllUserLoginTests01() {
////        List<UserLogin> userList = dao.findAll();
//        System.out.print(userList.toString());
//        assertNotNull(userList);
//        
//        
//    }
//	
//	
//	@Test
//    @DisplayName("Test for getting UserLogin by ID")
//    public void ReturnUserLoginByIDTest() {
//		UserLogin Userlogin = dao.findById(1).orElse(null);
//        assertNotNull(Userlogin);
//        
//    }
//	
//	
//	@Test
//    @DisplayName("Test for getting UserLogin by ID that doesn't exist")
//    public void ReturnUserLoginByIDTest02() {
//		UserLogin UserLogin = dao.findById(888).orElse(null);
//        assertNull(UserLogin);
//        
//    }
//	
//	
//	   @Test
//	   @DisplayName("Test if UserLogin is added sucessfully")
//	   public void AddUserLoginTest() {
//	  
//		   String userLoginName = "test";
//		   String passcode = "passcode";
//		   
//		   
//		    
//	   int result = dao.insertUserLoginData(userLoginName,passcode);
//
//			  
//		    assertEquals(1, result);
//		  }
//	   
//	   
//	   
//
//	   @Test
//	   @DisplayName("Test if UserLogin is deleted sucessfully")
//	   public void DeleteUserLoginTest() {   
//	   dao.deleteById(4);
//	   UserLogin UserLogin = dao.findById(4).orElse(null);
//	   assertNull(UserLogin);
//	  
//	   
//	   }
//	   
//	   
//	   @Test
//	   @DisplayName("Test if Password is updated sucessfully")
//	   public void UpdatePasswordTest() { 
//		   
//	   int userLoginId = 2;
//	   String newPassword = "1234";
//	   String salt1 = "2345";
//	   
//	   int result = dao.updatePassword(salt1, newPassword , userLoginId);
//	    
//	    
//		   assertEquals(1, result);
//		   
//		   
//		   
//	   }
//			
//	   
//}
