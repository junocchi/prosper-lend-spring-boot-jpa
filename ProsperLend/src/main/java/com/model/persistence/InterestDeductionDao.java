package com.model.persistence;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dto.entity.InterestDeduction;

@Transactional

@Repository
public interface InterestDeductionDao extends JpaRepository<InterestDeduction, Integer>{
	
	
	
	@Modifying
	@Query("update InterestDeduction set deductionAmount=deductionAmount+:am where interestDeductionId=:id")
	int updateDeductionAmountById(@Param("id") int loanId,@Param("am") Double newAmount);
	
	
	@Modifying
	@Query(value = "insert into InterestDeductions (items, deductionAmount) VALUES  (items, deductionAmount)",nativeQuery = true)
	int addDeduction(String items, Double amount);
	
	
	 
	
}

	
