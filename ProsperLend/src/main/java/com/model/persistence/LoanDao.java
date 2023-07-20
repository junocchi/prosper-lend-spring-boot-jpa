package com.model.persistence;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dto.entity.Loans;



@Transactional
@Repository
public interface LoanDao extends JpaRepository<Loans, Integer>{
	
	
	@Modifying
	@Query("update Loans set amount=amount+:am, interest=interest+:in where loanID=:id")
	int updateSalaryAmountById(@Param("id") int loanId,@Param("am") BigDecimal newAmount, @Param("in") BigDecimal newInterest);
	
	
	@Modifying
	@Query(value = "insert into Loans values(?,?,?,?,?)",nativeQuery = true)
	int insertLoan(int loanId,BigDecimal amount, BigDecimal interest, int businessID,
	Date loanDate);


	
}



