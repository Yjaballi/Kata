package com.kata.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.exception.NullObjectException;
import com.kata.model.BankTransaction;
import com.kata.repository.BankTransactionRepository;
import com.kata.service.BankTransactionService;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

    private final BankTransactionRepository bankTransactionRepository;

    @Autowired
    public BankTransactionServiceImpl(BankTransactionRepository bankTransactionRepository) {
        this.bankTransactionRepository = bankTransactionRepository;
    }

    @Override
    public void saveBankTransaction(BankTransaction transaction) {
    	if(transaction == null) {
            throw new NullObjectException("MISSING BANK TRANSACTION");
    	}
        bankTransactionRepository.save(transaction);
    }

    @Override
    public List<BankTransaction> getBankTransactionsBySenderAccountIdOrReceiverAccountId(String senderAccountId,
            String receiverAccountId) {
    	
    	if (senderAccountId == null && receiverAccountId == null) {
    		
            throw new NullObjectException("MISSONG SENDER ACCOUNT ID AND RECEIVER ACCOUNT ID");
        }
    	else if(senderAccountId == null){
    		throw new NullObjectException("MISSONG SENDER ACCOUNT ID");
    	}
    	else if(receiverAccountId == null) {
    		throw new NullObjectException("MISSONG RECEIVER ACCOUNT ID");
    	}
        return bankTransactionRepository.findBySenderAccountIdOrReceiverAccountId(senderAccountId, receiverAccountId);
    }

    @Override
    public List<BankTransaction> getBankTransactionsByAmountGreaterThan(double amount) {
        return bankTransactionRepository.findByAmountGreaterThan(amount);
    }
}
