package com.model.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dto.entity.Businesses;




@Transactional
@Repository
public interface BusinessDao extends JpaRepository<Businesses, Integer> {
	
	
	@Modifying
	@Query("update Businesses set businessAdminEmail=businessAdminEmail+:em  where businessID=:id")
	int updateBusinessEmail(@Param("id") int businessId,@Param("em") String businessAdminEmail);
	
	
	@Modifying
	@Query(value = "insert into Businesses (userLoginId, businessName,businessAdminEmail,MerchantId) values(userLoginId, businessName,businessAdminEmail,MerchantId)",nativeQuery = true)
	int addBusisness(int userLoginID, String businessName, String businessAdminEmail, long MerchantId);
	

}
