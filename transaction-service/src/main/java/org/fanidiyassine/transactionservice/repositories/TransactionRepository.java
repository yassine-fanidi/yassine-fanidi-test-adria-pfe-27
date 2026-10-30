package org.fanidiyassine.transactionservice.repositories;

import org.fanidiyassine.transactionservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
