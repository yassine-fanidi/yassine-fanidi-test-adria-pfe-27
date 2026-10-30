package org.fanidiyassine.accountservice.controllers;

import org.fanidiyassine.accountservice.entities.BankAccount;
import org.fanidiyassine.accountservice.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {
    private BankAccountService bankAccountService;
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return bankAccountService.findBankAccountById(id);
    }

    @PostMapping("/accounts")
    public BankAccount saveBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.saveBankAccount(bankAccount);
    }
}
