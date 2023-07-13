package com.kata.service;

import java.util.List;

import com.kata.model.BankAccount;
import com.kata.model.BankClient;


public interface BankAccountService {
    void saveBankAccount(BankAccount account);
    BankAccount getBankAccountById(String id);
    List<BankAccount> getBankAccountsByClient(BankClient client);
    List<BankAccount> getBankAccountsByBalanceGreaterThan(double amount);
    void deposit(String accountId, double amount);
    void withdraw(String accountId, double amount);
}

