package com.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.kata.model.BankOperation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kata.model.BankAccount;
import com.kata.service.BankAccountService;
import com.kata.service.BankOperationService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bank-operations")
public class BankOperationController {
	
	@Autowired
    private  BankOperationService bankOperationService;

	@Autowired
    private  BankAccountService bankAccountService;
	
    @Autowired
    public BankOperationController(BankOperationService bankOperationService) {
        this.bankOperationService = bankOperationService;
    }

    @PostMapping
    public void saveBankOperation(@RequestBody BankOperation operation) {
    	
    	if(operation.getBankAccount() != null) {
          BankAccount  operationBankAccount = bankAccountService.getBankAccountById(operation.getBankAccount().getId().toString());
          if(operation.getAmount() <operationBankAccount.getBalance()) {
          bankOperationService.saveBankOperation(operation);
          double newBankBalance = operationBankAccount.getBalance() - operation.getAmount();
          operationBankAccount.setBalance(newBankBalance);
          bankAccountService.saveBankAccount(operationBankAccount);
          }
    	}
    }

    
    @GetMapping("/account/{accountId}")
    public List<BankOperation> getBankOperationsByAccountId(@PathVariable Long accountId) {
        return bankOperationService.getBankOperationsByBankAccount(new BankAccount(accountId));
    }

    @GetMapping("/account/{accountId}/date-range")
    public List<BankOperation> getBankOperationsByAccountIdAndDateRange(
            @PathVariable Long accountId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return bankOperationService.getBankOperationsByBankAccountAndDateRange(new BankAccount(accountId), startDate, endDate);
    }

    @GetMapping("/account/{accountId}/latest")
    public List<BankOperation> getBankOperationsByAccountIdOrderByDateDesc(@PathVariable Long accountId) {
        return bankOperationService.getBankOperationsByBankAccountOrderByDateDesc(new BankAccount(accountId));
    }
}
