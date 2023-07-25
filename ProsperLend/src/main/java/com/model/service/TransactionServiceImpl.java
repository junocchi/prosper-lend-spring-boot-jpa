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
	public Transaction getTransactionById(int transactionId) {
		return transactionDao.findById(transactionId).orElse(null);
	}
	
	
	
	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return transactionDao.findAll();
	}

	@Override
	public boolean insertNewTransaction(Transaction transaction) {
		try {
			if(transactionDao.addTransaction( 
					transaction.getLoan().getLoanID(), transaction.getAmount(),
					transaction.getTransactionDate())>0)
				return true;
			}
			catch(Exception ex) {
				return false;
			}
			return false;
	}


	@Override
	public boolean changeAmount(int transactionId, double newAmount) {
		
		if(transactionDao.updateAmount(transactionId, transactionId)>0)
			return true;
		else
			return false;
	}

	
}



