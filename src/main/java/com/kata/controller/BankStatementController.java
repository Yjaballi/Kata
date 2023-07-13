package com.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.kata.model.BankStatement;
import com.kata.model.BankAccount;
import com.kata.service.BankStatementService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bank-statements")
public class BankStatementController {
    
    private final BankStatementService bankStatementService;

    @Autowired
    public BankStatementController(BankStatementService bankStatementService) {
        this.bankStatementService = bankStatementService;
    }

    @PostMapping
    public void saveBankStatement(@RequestBody BankStatement statement) {
        bankStatementService.saveBankStatement(statement);
    }

    @GetMapping("/{id}")
    public BankStatement getBankStatementById(@PathVariable Long id) {
        return bankStatementService.getBankStatementById(id);
    }

 
}
