package com.example.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import com.example.enums.AccountType;

import lombok.Builder;
import lombok.Data;

@Data // Lombok annotation to generate getters and setters
@Builder // Lombok annotation to generate builder pattern
public class Account {

    private UUID id;
    private BigDecimal balance;
    private AccountType accountType;
    private Date creationDate;
    private Long userId;

}
