package org.fanidiyassine.accountservice.models;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class CustomerModel {
    private Long id;
    private String name;
    private String email;
}
