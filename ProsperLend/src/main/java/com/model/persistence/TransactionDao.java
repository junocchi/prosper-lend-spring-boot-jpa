package com.model.persistence;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dto.entity.Transaction;

@Transactional
@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {
	
	
	@Modifying
	@Query(value = "insert into Transactions (loanID, amount, transactionDate) VALUES(loanID, amount, transactionDate)",nativeQuery = true)
	int addTransaction( int loanID, double amount, Date transactionDate);

	
	
	@Modifying
	@Query("update Transaction set amount=amount+:a where transactionId=:id")
	int updateAmount(@Param("id") int transactionId, @Param("a") double newAmount);
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM TRANSACTIONS WHERE loanId = :id")
	List<Transaction> findAllTransactionsForLoan(@Param("id") int loanId);

}
