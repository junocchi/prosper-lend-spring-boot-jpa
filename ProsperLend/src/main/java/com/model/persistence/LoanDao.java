package com.model.persistence;

import java.math.BigDecimal;
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


import com.dto.entity.Loans;
import com.dto.entity.Transaction;



@Transactional
@Repository
public interface LoanDao extends JpaRepository<Loans, Integer>{
	
	@Modifying
	@Query("update Loans set amount=amount+:am, interest=interest+:in where loanID=:id")
	int updateLoansAmountById(@Param("id") int loanId,@Param("am") BigDecimal newAmount, @Param("in") BigDecimal newInterest);
	
	@Modifying
	@Query(value = "insert into LOANS (loanStatus, amount, interest, userLoginId, loanDate) VALUES (?, ?,  ? , ?, ?, ?)",nativeQuery = true)
	int addLoan(String loanStatus, BigDecimal amount, BigDecimal currentDebt, int userID, Date loanDate);
	
	
	@Query(value = "Select userLoginId from Loans where userLoginId=:id" ,nativeQuery = true)
	int getUserIdByLoanId(@Param("id") int loanId);
	
	 
//	@Query(value = "SELECT merchantId FROM userDetails INNER JOIN userDetails ON userLoginId=:id" ,nativeQuery = true)
//	long getMerchantByUserID(@Param("id") int loanId);
	
	@Query(value = "SELECT l.currentDebt FROM userdetails u INNER JOIN loans l ON u.userLoginId" ,nativeQuery = true)
	BigDecimal getDebtByUserID(@Param("id") int loanId);
	

	@Query(value = "insert into LOANS (loanStatus, amount, interest, userLoginId, loanDate) VALUES (?, ?, ?, ?, ?)",nativeQuery = true)
	int addLoan(String loanStatus, Double amount, Double interest, int userID, Date loanDate); 

	
}



