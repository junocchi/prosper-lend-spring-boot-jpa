package com.model.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dto.entity.UserLogin;

@Transactional
@Repository
public interface UserLoginDao extends JpaRepository<UserLogin, Integer>{

	
	@Modifying
	@Query(value = "insert into userlogin (userLoginName, passcode) values (?, ?)", nativeQuery = true)
	public int insertUserLoginData(String userLoginName, String passcode);
	
	
	@Modifying
	@Query(nativeQuery = true,value = "update userlogin set passcode = SHA1(concat(?,?)) where userLoginId=?")
	public int updatePassword(String salt1, String passcode,int userLoginId);
}
