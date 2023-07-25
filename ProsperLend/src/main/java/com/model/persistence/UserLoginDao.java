package com.model.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dto.entity.UserLogin;

@Repository
public interface UserLoginDao extends JpaRepository<UserLogin, Integer>{

	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "insert into userlogin (userLoginName, passcode, salt, userRole) values(?, SHA1(concat(?,?), ?, ?)")
	public int insertUserLoginData(String username, String salt1, String passcode, String salt, String role);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "update userlogin set passcode = SHA1(concat(?,?)) where userLoginId=?")
	public int updatePassword(String salt1, String passcode,int userLoginId);
	
//	@Query("FROM UserLogins WHERE userLoginName=:u")
//	public UserLogin findUserByUsername(@Param("u") String username);
}
