package org.fanidiyassine.transactionservice;

import org.fanidiyassine.transactionservice.entities.Transaction;
import org.fanidiyassine.transactionservice.services.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TransactionService transactionService) {
        return args -> {
            for (int i = 1; i <= 3; i++) {
                    transactionService.saveTransaction(Transaction.builder()
                            .amount((long) (1000 + Math.random() * 6000))
                            .accountId("Test")
                            .merchantCategory("ABCD")
                            .country(Math.random() > 0.5 ? "morocco" : "usa")
                            .currency(Math.random() > 0.5 ? "DH" : "$")
                            .build());
            }
        };
    }
}
