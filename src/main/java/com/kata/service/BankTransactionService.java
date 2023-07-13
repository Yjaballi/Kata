package com.kata.service;

import java.util.List;

import com.kata.model.BankTransaction;

public interface BankTransactionService {
    void saveBankTransaction(BankTransaction transaction);
    List<BankTransaction> getBankTransactionsBySenderAccountIdOrReceiverAccountId(String senderAccountId, String receiverAccountId);
    List<BankTransaction> getBankTransactionsByAmountGreaterThan(double amount);
}
