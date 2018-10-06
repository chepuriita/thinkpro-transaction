package com.thinkpro.transaction.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkpro.transaction.domain.Transaction;
import com.thinkpro.transaction.service.TransactionService;

@RestController
@RequestMapping("/")
public class TransactionResource {

	@Autowired
	private TransactionService transactionService;

	@GetMapping(path = "get/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transaction> getTransaction(@PathVariable("transactionId") int transactionId) {
		System.out.println("transactionId ----->:" + transactionId);
		Transaction transaction = transactionService.getByTransactionId(transactionId);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "TransactionResource");
		return ResponseEntity.accepted().headers(headers).body(transaction);
	}

	@PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
		System.out.println("Transaction Id----->:" + transaction.getTransactionId());
		Transaction transactionRef = transactionService.create(transaction);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "TransactionResource");
		return ResponseEntity.accepted().headers(headers).body(transactionRef);

	}

}
