package com.example.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.enums.AccountType;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;

@Component
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createNewAccount(BigDecimal balance, Date creationDate, Long userId, AccountType accountType) {

        // We need to create Account object
        Account account = Account.builder()
                .id(UUID.randomUUID())
                .userId(userId).accountType(accountType)
                .creationDate(creationDate).balance(balance).build();

        // Save it to the database(repository)
        // Return the Account object

        return accountRepository.save(account);

    }

    @Override
    public List<Account> listAllAccounts() {
        return accountRepository.findAll();
    }

}
