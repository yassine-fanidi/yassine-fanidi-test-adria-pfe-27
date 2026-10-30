package org.fanidiyassine.transactionservice.controllers;

import org.fanidiyassine.transactionservice.entities.Transaction;
import org.fanidiyassine.transactionservice.models.BankAccountModel;
import org.fanidiyassine.transactionservice.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class TransactionController {
    private TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable String id) {
        return transactionService.getTransactionById(id);
    }
    @PostMapping("/transactions")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }
}
