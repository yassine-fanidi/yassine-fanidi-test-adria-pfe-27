package org.fanidiyassine.transactionservice.services;

import org.fanidiyassine.transactionservice.entities.Transaction;
import org.fanidiyassine.transactionservice.feign.AccountRestClient;
import org.fanidiyassine.transactionservice.models.BankAccountModel;
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
    private AccountRestClient accountRestClient;
    public TransactionService(TransactionRepository transactionRepository, AccountRestClient accountRestClient) {
        this.transactionRepository = transactionRepository;
        this.accountRestClient = accountRestClient;
    }
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public Transaction getTransactionById(String id) {
        return transactionRepository.findById(id).orElseThrow(()->new RuntimeException("Transaction with id "+id+" not found"));
    }
    public Transaction saveTransaction(Transaction transaction) {
        try {
            BankAccountModel bankAccount = accountRestClient.getBankAccountById(transaction.getAccountId());
            System.out.println("Hello from here");
            transaction.setId(UUID.randomUUID().toString());
            transaction.setAccountId(bankAccount.getId());
            transaction.setCreatedAt(new Date());
            return transactionRepository.save(transaction);
        }
        catch (Exception e) {
            throw new RuntimeException("Save transaction failed");
        }
    }
}
