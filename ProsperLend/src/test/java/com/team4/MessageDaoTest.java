<<<<<<< HEAD
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

import com.dto.entity.Messages;

import com.dto.entity.UserLogin;

import com.model.persistence.MessageDao;
import com.model.persistence.UserLoginDao;




@ActiveProfiles("test")
@SpringBootTest


class MessageDaoTest {
	
	
	@Autowired
	private MessageDao dao;
	

	
	
	
	
	
	@Test
    @DisplayName("Test for getting all messages")
    public void ReturnAllMessagesTests01() {
        List<Messages> messageList = dao.findAll();
        System.out.print(messageList.toString());
        assertNotNull(messageList);
        
        
    }
	
	
	@Test
    @DisplayName("Test for getting message by ID")
    public void ReturnMessageByIDTest() {
		Messages message = dao.findById(2).orElse(null);
        assertNotNull(message);
        
    }
	
	
	@Test
    @DisplayName("Test for getting message by ID that doesn't exist")
    public void ReturnMessageByIDTest02() {
		Messages message = dao.findById(888).orElse(null);
        assertNull(message);
        
    }
	
	
	   @Test
	   @DisplayName("Test if message is added sucessfully")
	   public void AddMessageTest() {
	  
       String userEmail = "MyEmail@SQL.com";
       String userName = "Test";
       String message = "Test Message";
    
		    
	   int result = dao.addMessage(userEmail,userName, message);

			  
		    assertEquals(1, result);
		  }
	   
	   
	   

	   @Test
	   @DisplayName("Test if message is deleted sucessfully")
	   public void DeleteBusinessTest() {   
	   dao.deleteById(2);
	   Messages message = dao.findById(2).orElse(null);
	   assertNull(message);
	  
	   
	   }
	   
	   
	   @Test
	   @DisplayName("Test if Message is updated sucessfully")
	   public void UpdateBusinessTest() { 
		   
	   int messageID = 1;
	   String newMessage = "Test update";
	   
	   
	   int result = dao.updateMessage(messageID, newMessage);
	    
	    
		   assertEquals(1, result);
		   
		   
		   
	   }
	   
	   
	   
			
	   
}
=======
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
//import com.dto.entity.Messages;
//
//import com.dto.entity.UserLogin;
//import com.model.persistence.BusinessDao;
//import com.model.persistence.MessageDao;
//import com.model.persistence.UserLoginDao;
//
//
//
//
//@ActiveProfiles("test")
//@SpringBootTest
//
//
//class MessageDaoTest {
//	
//	
//	@Autowired
//	private MessageDao dao;
//	
//
//	
//	
//	
//	
//	
//	@Test
//    @DisplayName("Test for getting all messages")
//    public void ReturnAllMessagesTests01() {
//        List<Messages> messageList = dao.findAll();
//        System.out.print(messageList.toString());
//        assertNotNull(messageList);
//        
//        
//    }
//	
//	
//	@Test
//    @DisplayName("Test for getting message by ID")
//    public void ReturnMessageByIDTest() {
//		Messages message = dao.findById(2).orElse(null);
//        assertNotNull(message);
//        
//    }
//	
//	
//	@Test
//    @DisplayName("Test for getting message by ID that doesn't exist")
//    public void ReturnMessageByIDTest02() {
//		Messages message = dao.findById(888).orElse(null);
//        assertNull(message);
//        
//    }
//	
//	
//	   @Test
//	   @DisplayName("Test if message is added sucessfully")
//	   public void AddMessageTest() {
//	  
//       String userEmail = "MyEmail@SQL.com";
//       String userName = "Test";
//       String message = "Test Message";
//    
//		    
//	   int result = dao.addMessage(userEmail,userName, message);
//
//			  
//		    assertEquals(1, result);
//		  }
//	   
//	   
//	   
//
//	   @Test
//	   @DisplayName("Test if message is deleted sucessfully")
//	   public void DeleteBusinessTest() {   
//	   dao.deleteById(2);
//	   Messages message = dao.findById(2).orElse(null);
//	   assertNull(message);
//	  
//	   
//	   }
//	   
//	   
//	   @Test
//	   @DisplayName("Test if Message is updated sucessfully")
//	   public void UpdateBusinessTest() { 
//		   
//	   int messageID = 1;
//	   String newMessage = "Test update";
//	   
//	   
//	   int result = dao.updateMessage(messageID, newMessage);
//	    
//	    
//		   assertEquals(1, result);
//		   
//		   
//		   
//	   }
//	   
//	   
//	   
//			
//	   
//}
>>>>>>> 96c44370fdcab96f604ddb2f9cd78442a4c155dc
