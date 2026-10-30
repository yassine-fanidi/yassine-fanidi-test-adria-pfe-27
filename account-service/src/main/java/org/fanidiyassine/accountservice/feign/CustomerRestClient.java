package org.fanidiyassine.accountservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.fanidiyassine.accountservice.models.CustomerModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customer-service", fallbackMethod = "getDefaultCustomer")
    @Bean
    CustomerModel getCustomerById(@PathVariable Long id);

    default CustomerModel getDefaultCustomer(Long id, Exception e) {
        return new CustomerModel(id, "Not available", "Not available");
    }
}
