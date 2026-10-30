package org.fanidiyassine.accountservice.services;

import org.fanidiyassine.accountservice.entities.BankAccount;
import org.fanidiyassine.accountservice.models.CustomerModel;
import org.fanidiyassine.accountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BankAccountService {
    private BankAccountRepository bankAccountRepository;


    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getAllBankAccounts(){
        return bankAccountRepository.findAll();
    }

    public BankAccount findBankAccountById(String id){
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Bank account not found"));
    }

    public BankAccount saveBankAccount(BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }
}
