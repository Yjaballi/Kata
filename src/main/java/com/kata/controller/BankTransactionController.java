package com.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kata.model.BankAccount;
import com.kata.model.BankTransaction;
import com.kata.service.BankAccountService;
import com.kata.service.BankTransactionService;

import java.util.List;

@RestController
@RequestMapping("/bank-transactions")
public class BankTransactionController {
	@Autowired
    private BankTransactionService bankTransactionService;
	
	
	@Autowired
    private BankAccountService bankAccountService;

    @Autowired // Inject the BankTransactionService bean
    public BankTransactionController(BankTransactionService bankTransactionService) {
        this.bankTransactionService = bankTransactionService;
    }

    @PostMapping
    public void saveBankTransaction(@RequestBody BankTransaction transaction) {
        if (transaction.getSenderAccountId() == null || transaction.getReceiverAccountId() == null) {
            // Handle missing sender or receiver account ID
            // You can throw an exception, return an error response, or take appropriate action based on your application's requirements
            return;
        }
        
        BankAccount senderAccount = bankAccountService.getBankAccountById(transaction.getSenderAccountId());
        BankAccount receiverAccount = bankAccountService.getBankAccountById(transaction.getReceiverAccountId());
        
        if (senderAccount == null || receiverAccount == null) {
            // Handle invalid sender or receiver account
            // You can throw an exception, return an error response, or take appropriate action based on your application's requirements
            return;
        }
        
        double transactionAmount = transaction.getAmount();
        double senderNewBalance = senderAccount.getBalance() - transactionAmount;
        double receiverNewBalance = receiverAccount.getBalance() + transactionAmount;

        senderAccount.setBalance(senderNewBalance);
        receiverAccount.setBalance(receiverNewBalance);

        bankAccountService.saveBankAccount(senderAccount);
        bankAccountService.saveBankAccount(receiverAccount);
        
        bankTransactionService.saveBankTransaction(transaction);
        
    }

    

    @GetMapping("/sender-or-receiver")
    public List<BankTransaction> getBankTransactionsBySenderAccountIdOrReceiverAccountId(
            @RequestParam(required = false) String senderAccountId,
            @RequestParam(required = false) String receiverAccountId) {
        return bankTransactionService.getBankTransactionsBySenderAccountIdOrReceiverAccountId(senderAccountId, receiverAccountId);
    }

    @GetMapping("/amount-greater-than")
    public List<BankTransaction> getBankTransactionsByAmountGreaterThan(@RequestParam double amount) {
        return bankTransactionService.getBankTransactionsByAmountGreaterThan(amount);
    }
}

