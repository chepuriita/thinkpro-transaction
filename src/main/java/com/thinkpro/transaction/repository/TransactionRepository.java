package com.thinkpro.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkpro.transaction.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
