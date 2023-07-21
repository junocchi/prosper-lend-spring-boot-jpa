package com.model.persistence;

import java.sql.Date;
import java.util.List;

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
	int updateSalaryAmountById(@Param("id") int loanId,@Param("am") Double newAmount, @Param("in") Double newInterest);
	
	
	@Modifying
	@Query(value = "insert into Loans values(?,?,?,?,?,?)",nativeQuery = true)
	int addLoan(int loanId,Double amount, Double interest, int businessID,
	Date loanDate, List<Transaction> transactions);


	
}



