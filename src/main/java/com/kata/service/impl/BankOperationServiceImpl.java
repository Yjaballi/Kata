package com.kata.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.BankOperation;
import com.kata.model.BankAccount;
import com.kata.repository.BankOperationRepository;
import com.kata.service.BankOperationService;

@Service
public class BankOperationServiceImpl implements BankOperationService {

	@Autowired
    private final BankOperationRepository bankOperationRepository;

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
        Objects.requireNonNull(bankAccount, "Bank account must not be null.");
        return bankOperationRepository.findByBankAccount(bankAccount);
    }

    @Override
    public List<BankOperation> getBankOperationsByBankAccountAndDateRange(BankAccount bankAccount, Date startDate, Date endDate) {
        Objects.requireNonNull(bankAccount, "Bank account must not be null.");
        return bankOperationRepository.findByBankAccountAndDateBetween(bankAccount, startDate, endDate);
    }

    @Override
    public List<BankOperation> getBankOperationsByBankAccountOrderByDateDesc(BankAccount bankAccount) {
        Objects.requireNonNull(bankAccount, "Bank account must not be null.");
        return bankOperationRepository.findByBankAccountOrderByDateDesc(bankAccount);
    }
}
