package com.kata.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kata.model.BankTransaction;

public interface BankTransactionRepository extends CrudRepository<BankTransaction, Long> {
    List<BankTransaction> findBySenderAccountIdOrReceiverAccountId(String senderAccountId, String receiverAccountId);
    List<BankTransaction> findByAmountGreaterThan(double amount);
    // Other specific methods if needed
}
