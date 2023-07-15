package com.kata.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.BankOperation;
import com.kata.model.BankAccount;
import com.kata.repository.BankOperationRepository;
import com.kata.service.BankOperationService;
import com.kata.exception.NullObjectException;

@Service
public class BankOperationServiceImpl implements BankOperationService {
	
	@Autowired
    private BankOperationRepository bankOperationRepository;


    @Override
    public void saveBankOperation(BankOperation operation) {
        bankOperationRepository.save(operation);
    }

    @Override
    public List<BankOperation> getBankOperationsByBankAccount(BankAccount bankAccount) {
        if (bankAccount == null) {
            throw new NullObjectException();
        }
        return bankOperationRepository.findByBankAccount(bankAccount);
    }

    @Override
    public List<BankOperation> getBankOperationsByBankAccountAndDateRange(BankAccount bankAccount, Date startDate, Date endDate) {
        if (bankAccount == null) {
            throw new NullObjectException();
        }
        return bankOperationRepository.findByBankAccountAndDateBetween(bankAccount, startDate, endDate);
    }

    @Override
    public List<BankOperation> getBankOperationsByBankAccountOrderByDateDesc(BankAccount bankAccount) {
        if (bankAccount == null) {
            throw new NullObjectException();
        }
        return bankOperationRepository.findByBankAccountOrderByDateDesc(bankAccount);
    }
}
