package org.fanidiyassine.transactionservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity @Getter @Setter @AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    private String id;
    private String accountId;
    private Long amount;
    private String currency;
    private String merchantCategory;
    private String country;
    private Date createdAt;
}
