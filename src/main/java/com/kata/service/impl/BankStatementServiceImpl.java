package com.kata.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.BankStatement;
import com.kata.repository.BankStatementRepository;
import com.kata.service.BankStatementService;

@Service
public class BankStatementServiceImpl implements BankStatementService {
	
	@Autowired
    private final BankStatementRepository bankStatementRepository;

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
        Optional<BankStatement> optionalStatement = bankStatementRepository.findById(id);
        return optionalStatement.orElseThrow(() -> new IllegalArgumentException("Invalid bank statement ID."));
    }
}
