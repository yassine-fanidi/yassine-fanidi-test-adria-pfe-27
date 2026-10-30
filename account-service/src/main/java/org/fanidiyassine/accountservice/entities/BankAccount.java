package org.fanidiyassine.accountservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.fanidiyassine.accountservice.emuns.AccountStatus;

@Entity @Getter
@Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private String customerRef;
    private AccountStatus status;
    private String currency;
    private double balance;
}
