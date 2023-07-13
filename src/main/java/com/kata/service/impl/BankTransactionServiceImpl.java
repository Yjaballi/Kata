package com.kata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.BankTransaction;
import com.kata.repository.BankTransactionRepository;
import com.kata.service.BankTransactionService;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {
    
	@Autowired
    private BankTransactionRepository bankTransactionRepository;

    @Autowired
    public BankTransactionServiceImpl(BankTransactionRepository bankTransactionRepository) {
        this.bankTransactionRepository = bankTransactionRepository;
    }

    @Override
    public void saveBankTransaction(BankTransaction transaction) {
        bankTransactionRepository.save(transaction);
    }
    
    @Override
	public List<BankTransaction> getBankTransactionsBySenderAccountIdOrReceiverAccountId(String senderAccountId,
			String receiverAccountId) {
    	return bankTransactionRepository.findBySenderAccountIdOrReceiverAccountId(senderAccountId,receiverAccountId);
	}
    
   

    @Override
    public List<BankTransaction> getBankTransactionsByAmountGreaterThan(double amount) {
        return bankTransactionRepository.findByAmountGreaterThan(amount);
    }

	
}
