package org.fanidiyassine.accountservice.services;

import org.fanidiyassine.accountservice.entities.BankAccount;
import org.fanidiyassine.accountservice.feign.CustomerRestClient;
import org.fanidiyassine.accountservice.models.CustomerModel;
import org.fanidiyassine.accountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;


    public BankAccountService(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    public List<BankAccount> getAllBankAccounts(){
        return bankAccountRepository.findAll();
    }

    public BankAccount findBankAccountById(String id){
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Bank account not found"));
    }

    public BankAccount saveBankAccount(BankAccount bankAccount){
        try {
            CustomerModel customer = customerRestClient.getCustomerById(bankAccount.getCustomerRef());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCustomerRef(customer.getId());
            return bankAccountRepository.save(bankAccount);
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
