package com.kata.service;

import java.util.Date;
import java.util.List;

import com.kata.model.BankOperation;
import com.kata.model.BankAccount;

public interface BankOperationService {
    void saveBankOperation(BankOperation operation);
    List<BankOperation> getBankOperationsByBankAccount(BankAccount bankAccount);
    List<BankOperation> getBankOperationsByBankAccountAndDateRange(BankAccount bankAccount, Date startDate, Date endDate);
    List<BankOperation> getBankOperationsByBankAccountOrderByDateDesc(BankAccount bankAccount);
}
