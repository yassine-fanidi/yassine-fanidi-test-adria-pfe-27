package org.fanidiyassine.accountservice;

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

//	@Bean
//	CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
//		return args -> {
//
//		}
//	}

}
