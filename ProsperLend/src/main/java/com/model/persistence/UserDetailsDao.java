package com.model.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dto.entity.UserDetails;

@Transactional
@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, Integer>{

	
	@Modifying
	@Query(value = "insert into userDetails (userLoginName, passcode, businessName, businessAdminEmail, merchantId) values (?, ? , ? , ? , ?)", nativeQuery = true)
	public int insertUserLoginData(String userLoginName, String passcode, String businessName, String businessAdminEmail, Long merchantId);
	
	
	@Modifying
	@Query(nativeQuery = true,value = "update userDetails set passcode = (?) where userLoginId=?")
	public int updatePassword(String passcode,int userLoginId);
}
