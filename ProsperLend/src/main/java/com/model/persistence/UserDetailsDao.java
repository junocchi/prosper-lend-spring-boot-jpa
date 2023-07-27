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
	@Query(value = "insert into userDetails (userLoginName, passcode, salt, businessName, businessAdminEmail, merchantId, image) values (?, SHA1(concat(?,?)), ? , ? , ? , ? , ?)", nativeQuery = true)

	public int insertUserLoginData(String userLoginName, String salt1, String passcode, String salt, String businessName, String businessAdminEmail, Long merchantId, String image);
	
	@Modifying
	@Query(nativeQuery = true,value = "update userDetails set passcode = (?) where userLoginId=?")
	public int updatePassword(String passcode,int userLoginId);
	
	@Query(nativeQuery = true,value = "SELECT * FROM userDetails WHERE userLoginName = ?")
	public UserDetails getUserByUsername(String username);
	
	@Query(nativeQuery = true,value = "SELECT * FROM UserDetails WHERE userLoginName = ? AND passcode = SHA1(concat(salt, ?)) ")
	public UserDetails matchUsernamePassword(String username, String password);
	
	@Query(nativeQuery = true,value = "SELECT * FROM UserDetails WHERE userLoginName = ? ")
	public UserDetails getImageByUsername(String username);
}
