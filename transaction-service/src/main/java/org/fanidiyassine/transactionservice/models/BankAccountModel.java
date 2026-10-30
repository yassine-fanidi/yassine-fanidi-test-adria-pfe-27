package org.fanidiyassine.transactionservice.models;

import lombok.*;
import org.fanidiyassine.transactionservice.enums.AccountStatus;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountModel {
    private String id;
    private Long customerRef;
    private AccountStatus status;
    private String currency;
    private double balance;
}
