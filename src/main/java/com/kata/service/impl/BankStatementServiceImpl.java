package com.kata.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.BankStatement;
import com.kata.repository.BankStatementRepository;
import com.kata.service.BankStatementService;
import com.kata.exception.InvalidIdException;
import com.kata.exception.NullObjectException;

@Service
public class BankStatementServiceImpl implements BankStatementService {
	
	@Autowired
    private BankStatementRepository bankStatementRepository;

    

    @Override
    public void saveBankStatement(BankStatement statement) {
    	if (statement == null) {
            throw new NullObjectException();
        }
        bankStatementRepository.save(statement);
    }

    @Override
    public BankStatement getBankStatementById(Long id) {
        Optional<BankStatement> optionalStatement = bankStatementRepository.findById(id);
        return optionalStatement.orElseThrow(() -> new InvalidIdException("Invalid bank statement ID: " + id));
    }

}
