package com.kata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kata.model.BankAccount;
import com.kata.model.BankClient;
import com.kata.model.BankOperation;
import com.kata.service.BankAccountService;
import com.kata.service.BankOperationService;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;
    
    @Autowired
    private BankOperationService bankOperationService;

    @PostMapping
    public void saveBankAccount(@RequestBody BankAccount account) {
        bankAccountService.saveBankAccount(account);
    }

    @GetMapping("/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return bankAccountService.getBankAccountById(id);
    }

    @GetMapping("/client/{clientId}")
    public List<BankAccount> getBankAccountsByClient(@PathVariable String clientId) {
        BankClient client = new BankClient(Long.parseLong(clientId));
        return bankAccountService.getBankAccountsByClient(client);
    }

    @GetMapping("/balance-greater-than")
    public List<BankAccount> getBankAccountsByBalanceGreaterThan(@RequestParam double amount) {
        return bankAccountService.getBankAccountsByBalanceGreaterThan(amount);
    }

    @PostMapping("/{accountId}/deposit")
    public void deposit(@PathVariable String accountId, @RequestParam double amount) {
        bankAccountService.deposit(accountId, amount);
    }

    @PostMapping("/{accountId}/withdraw")
    public void withdraw(@PathVariable String accountId, @RequestParam double amount) {
        bankAccountService.withdraw(accountId, amount);
    }
    
    @GetMapping("/{accountId}/operations")
    public List<BankOperation> getBankAccountOperations(@PathVariable String accountId) {
        BankAccount account = bankAccountService.getBankAccountById(accountId);
        return bankOperationService.getBankOperationsByBankAccount(account);
    }
}
