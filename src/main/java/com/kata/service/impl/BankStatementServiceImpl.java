package com.kata.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.BankStatement;
import com.kata.model.BankAccount;
import com.kata.repository.BankStatementRepository;
import com.kata.service.BankStatementService;

@Service
public class BankStatementServiceImpl implements BankStatementService {
    
	@Autowired
    private BankStatementRepository bankStatementRepository;

    @Autowired
    public BankStatementServiceImpl(BankStatementRepository bankStatementRepository) {
        this.bankStatementRepository = bankStatementRepository;
    }

    @Override
    public void saveBankStatement(BankStatement statement) {
        bankStatementRepository.save(statement);
    }

    @Override
    public BankStatement getBankStatementById(Long id) {
        return bankStatementRepository.findById(id).orElse(null);
    }

   
}
