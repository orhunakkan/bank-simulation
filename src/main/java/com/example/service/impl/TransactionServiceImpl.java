package com.example.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.exception.BadRequestException;
import com.example.model.Account;
import com.example.model.Transaction;
import com.example.repository.AccountRepository;
import com.example.service.TransactionService;

@Component
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;

    public TransactionServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount, String message, Date creationDate) {
        validateAccount(sender, receiver);
        return null;
    }

    private void validateAccount(Account sender, Account receiver) {
        if (sender == null || receiver == null) {
            throw new BadRequestException("Sender or receiver account is null");
        }

        if (sender.getId().equals(receiver.getId())) {
            throw new BadRequestException("Sender and receiver account are the same");
        }

        findAccountById(sender.getId());
        findAccountById(receiver.getId());
    }

    private void findAccountById(UUID id) {
        accountRepository.findById(id);
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return null;
    }
    
}
