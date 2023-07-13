package com.kata.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.BankOperation;
import com.kata.model.BankAccount;
import com.kata.repository.BankOperationRepository;
import com.kata.service.BankOperationService;

@Service
public class BankOperationServiceImpl implements BankOperationService {
    
	@Autowired
    private BankOperationRepository bankOperationRepository;

    @Autowired
    public BankOperationServiceImpl(BankOperationRepository bankOperationRepository) {
        this.bankOperationRepository = bankOperationRepository;
    }

    @Override
    public void saveBankOperation(BankOperation operation) {
        bankOperationRepository.save(operation);
    }

    @Override
    public List<BankOperation> getBankOperationsByBankAccount(BankAccount bankAccount) {
        return bankOperationRepository.findByBankAccount(bankAccount);
    }

    @Override
    public List<BankOperation> getBankOperationsByBankAccountAndDateRange(BankAccount bankAccount, Date startDate, Date endDate) {
        return bankOperationRepository.findByBankAccountAndDateBetween(bankAccount, startDate, endDate);
    }

    @Override
    public List<BankOperation> getBankOperationsByBankAccountOrderByDateDesc(BankAccount bankAccount) {
        return bankOperationRepository.findByBankAccountOrderByDateDesc(bankAccount);
    }
}
