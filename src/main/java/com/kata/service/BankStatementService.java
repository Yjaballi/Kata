package com.kata.service;

import java.util.Date;
import java.util.List;

import com.kata.model.BankStatement;
import com.kata.model.BankAccount;

public interface BankStatementService {
    void saveBankStatement(BankStatement statement);
    BankStatement getBankStatementById(Long id);
    
}
