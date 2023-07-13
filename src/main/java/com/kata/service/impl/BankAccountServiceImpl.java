package com.kata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.BankAccount;
import com.kata.model.BankClient;
import com.kata.repository.BankAccountRepository;
import com.kata.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    
	@Autowired
	private BankAccountRepository bankAccountRepository;

     
	@Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void saveBankAccount(BankAccount account) {
        bankAccountRepository.save(account);
    }

    @Override
    public BankAccount getBankAccountById(String id) {
        return bankAccountRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public List<BankAccount> getBankAccountsByClient(BankClient client) {
        return bankAccountRepository.findByClient(client);
    }

    @Override
    public List<BankAccount> getBankAccountsByBalanceGreaterThan(double amount) {
        return bankAccountRepository.findByBalanceGreaterThan(amount);
    }
    
    
    @Override
    public void deposit(String accountId, double amount) {
        BankAccount account = bankAccountRepository.findById(Long.parseLong(accountId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid account ID"));

        account.deposit(amount);
        bankAccountRepository.save(account);
    }

    @Override
    public void withdraw(String accountId, double amount) {
        BankAccount account = bankAccountRepository.findById(Long.parseLong(accountId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid account ID"));

        account.withdraw(amount);
        bankAccountRepository.save(account);
    }

    
}
