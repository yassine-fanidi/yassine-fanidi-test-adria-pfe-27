package org.fanidiyassine.transactionservice.services;

import org.fanidiyassine.transactionservice.entities.Transaction;
import org.fanidiyassine.transactionservice.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable String id) {
        return transactionRepository.findById(id).orElseThrow(()->new RuntimeException("Transaction with id "+id+" not found"));
    }
    @PostMapping("/transactions")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        transaction.setId(UUID.randomUUID().toString());
        transaction.setCreatedAt(new Date());
        return transactionRepository.save(transaction);
    }
}
