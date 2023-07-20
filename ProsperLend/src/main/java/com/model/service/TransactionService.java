package com.model.service;

import java.util.List;

import com.dto.entity.Transaction;

public interface TransactionService {

	// As admin we can
	public List<Transaction> getAllTransactions();

	public Transaction insertNewTransaction(Transaction transaction);

	// As admin and business user we can
	public Transaction searchTransactionById(int transactionId);
}
