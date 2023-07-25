package com.model.service;

import java.util.List;

import com.dto.entity.Transaction;

public interface TransactionService {

	// As admin we can
	public List<Transaction> getAllTransactions();

	public boolean insertNewTransaction(Transaction transaction);

	// As admin and business user we can

	Transaction getTransactionById(int transactionId);

	boolean changeAmount(int transactionId, double newAmount);
}
