package com.thinkpro.transaction.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkpro.transaction.domain.Transaction;
import com.thinkpro.transaction.repository.TransactionRepository;
import com.thinkpro.transaction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction create(Transaction transaction) {
		transactionRepository.save(transaction);
		return transaction;
	}

	@Override
	public Transaction getByTransactionId(int transactionId) {
		
		return transactionRepository.getOne(transactionId);
	}

}
