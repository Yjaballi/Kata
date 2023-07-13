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
import com.kata.service.BankAccountService;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {
	
	@Autowired
    private BankAccountService bankAccountService;

    // Constructor

    /**
     * Saves a bank account.
     *
     * @param account The bank account to be saved.
     */
    @PostMapping
    public void saveBankAccount(@RequestBody BankAccount account) {
        bankAccountService.saveBankAccount(account);
    }

    /**
     * Retrieves a bank account by its ID.
     *
     * @param id The ID of the bank account.
     * @return The bank account with the specified ID.
     */
    @GetMapping("/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return bankAccountService.getBankAccountById(id);
    }

    /**
     * Retrieves a list of bank accounts associated with a client.
     *
     * @param clientId The ID of the client.
     * @return A list of bank accounts associated with the client.
     */
    @GetMapping("/client/{clientId}")
    public List<BankAccount> getBankAccountsByClient(@PathVariable String clientId) {
        BankClient client = new BankClient(Long.parseLong(clientId));
        return bankAccountService.getBankAccountsByClient(client);
    }

    /**
     * Retrieves a list of bank accounts with balances greater than the specified amount.
     *
     * @param amount The minimum balance amount.
     * @return A list of bank accounts with balances greater than the specified amount.
     */
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
}

