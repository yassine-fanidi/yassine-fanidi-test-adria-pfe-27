package org.fanidiyassine.accountservice;

import org.fanidiyassine.accountservice.emuns.AccountStatus;
import org.fanidiyassine.accountservice.entities.BankAccount;
import org.fanidiyassine.accountservice.repositories.BankAccountRepository;
import org.fanidiyassine.accountservice.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
		return args -> {
			for (int i = 1; i <= 3; i++) {
				for (int j = 0; j < 5; j++) {
					bankAccountService.saveBankAccount(BankAccount.builder()
							.balance(1000 + Math.random() * 60000)
							.status(Math.random() > 0.5 ? AccountStatus.ACTIVE : AccountStatus.BLOCKED)
							.customerRef((long) i)
							.currency(Math.random() > 0.5 ? "DH" : "$")
							.build());
				}
			}
		};
	}
}
