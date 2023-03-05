package com.example.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.enums.AccountType;
import com.example.model.Account;

public interface AccountService {

    Account createNewAccount(BigDecimal balance, Date creationDate, Long userId, AccountType accountType);

    List<Account> listAllAccounts();

}
