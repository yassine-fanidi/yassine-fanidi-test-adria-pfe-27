package org.fanidiyassine.transactionservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.fanidiyassine.transactionservice.enums.AccountStatus;
import org.fanidiyassine.transactionservice.models.BankAccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account-service")
public interface AccountRestClient {
    @GetMapping("/accounts/{id}")
    @CircuitBreaker(name = "account-service", fallbackMethod = "getDefaultAccount")
    BankAccountModel getBankAccountById(@PathVariable String id);

    default BankAccountModel getDefaultAccount(String id, Exception e) {
        return new BankAccountModel(id, 0L, AccountStatus.BLOCKED, "Not available", 0);
    }
}
