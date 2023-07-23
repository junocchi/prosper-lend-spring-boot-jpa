package com.model.persistence;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dto.entity.LoanDeduction;

@Transactional
@Repository

public interface LoanDeductionDao extends JpaRepository <LoanDeduction, Integer>{

	

	
	
	@Modifying
	@Query(value = "insert into LOANDEDUCTIONS (loanId, interestDeductionId) VALUES (loanId, interestDeductionId)",nativeQuery = true)
	int addLoanDeduction(int loanId, int interestDeductionId);
	
	
	
	
}
