package org.fanidiyassine.accountservice.repositories;

import org.fanidiyassine.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
