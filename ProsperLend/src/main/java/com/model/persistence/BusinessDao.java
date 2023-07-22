package com.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dto.entity.Businesses;

public interface BusinessDao extends JpaRepository<Businesses, Integer> {
	
	
	@Modifying
	@Query("update Businesses set businessAdminEmail=businessAdminEmail+:em  where businessID=:id")
	int updateBusinessEmail(@Param("id") int businessId,@Param("em") String businessAdminEmail);
	
	
	@Modifying
	@Query(value = "insert into Businesses values(businessId, userLoginId, businessName,businessAdminEmail,MerchantId)",nativeQuery = true)
	int addBusisness(int buisnessID,  String businessName,  String businessAdminEmail, int MerchantId);
	

}
