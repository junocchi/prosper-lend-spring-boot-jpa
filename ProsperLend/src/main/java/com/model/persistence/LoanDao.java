package com.model.persistence;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dto.entity.Business;
import com.dto.entity.Loans;
import com.dto.entity.Transaction;



@Transactional
@Repository
public interface LoanDao extends JpaRepository<Loans, Integer>{
	

	
	@Modifying
	@Query("update Loans set amount=amount+:am, interest=interest+:in where loanID=:id")
	int updateSalaryAmountById(@Param("id") int loanId,@Param("am") Double newAmount, @Param("in") Double newInterest);
	
	
	@Modifying
	@Query(value = "insert into Loans values(loanID,loanStatus,amount,interest,businessID,loanDate)",nativeQuery = true)
	int addLoan(int loanID,  String loanStatus, Double amount,  Double interest, Date loanDate);
	
	
	 
	
}



