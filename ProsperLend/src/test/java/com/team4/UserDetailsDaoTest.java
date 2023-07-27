package com.team4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;

import com.dto.entity.UserDetails;

import com.model.persistence.UserDetailsDao;

@ActiveProfiles("test")
@SpringBootTest
class UserDetailsDaoTest {

	@Autowired
	private UserDetailsDao dao;

	@Test
	@DisplayName("Test for getting all UserDetails")
	public void ReturnAllUserLoginTests01() {
		List<UserDetails> userList = dao.findAll();
		assertNotNull(userList);
	}

	@Test
	@DisplayName("Test for getting UserLogin by ID")
	public void ReturnUserLoginByIDTest() {
		UserDetails Userlogin = dao.findById(1).orElse(null);
		System.out.println(Userlogin);
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
		String email = "Email@email.com";
		long merchantId = 123442;
		String salt = "123456";
		String image = "test/path";

		int result = dao.insertUserLoginData(userLoginName, salt, passcode, salt, businessName, email, merchantId, image);
		
		assertEquals(1, result);
		
		int id = dao.getUserByUsername(userLoginName).getUserLoginId();
		dao.deleteById(id);
	}

	@Test
	@DisplayName("Test if UserLogin is deleted sucessfully")
	public void DeleteUserLoginTest() {
		String userLoginName = "test";
		String passcode = "passcode";
		String businessName = "BName";
		String email = "Email@email.com";
		long merchantId = 123442;
		String salt = "123456";
		String image = "test/path";
		
		dao.save(new UserDetails(99, userLoginName, passcode, salt, businessName, email, merchantId, image));
		
		assertNotNull(dao.findById(99).orElse(null));
		dao.deleteById(99);
		assertNull(dao.findById(99).orElse(null));

	}

	@Test
	@DisplayName("Test if Password is updated sucessfully")
	public void UpdatePasswordTest() {

		int userLoginId = 2;
		String newPassword = "1234";

		int result = dao.updatePassword(newPassword, userLoginId);

		assertEquals(1, result);
	}

}
