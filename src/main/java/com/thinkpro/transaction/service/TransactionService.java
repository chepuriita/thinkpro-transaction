package com.thinkpro.transaction.service;

import com.thinkpro.transaction.domain.Transaction;

public interface TransactionService {
	public Transaction create(Transaction transaction);	
	public Transaction getByTransactionId(int transactionId);

}
