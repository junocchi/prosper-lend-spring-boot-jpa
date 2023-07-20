package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Transaction;
import com.model.persistence.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return transactionDao.findAll();
	}

	@Override
	public Transaction insertNewTransaction(Transaction transaction) {
		if (searchTransactionById(transaction.getTransactionId()) == null)
			return transactionDao.save(transaction);
		else
			return null;
	}

	@Override
	public Transaction searchTransactionById(int transactionId) {
		Transaction transaction = transactionDao.findById(transactionId).orElse(null);
		return transaction;
	}

}
