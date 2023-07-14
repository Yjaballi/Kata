package com.kata.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kata.model.BankTransaction;

@Repository
public interface BankTransactionRepository extends CrudRepository<BankTransaction, Long> {
    List<BankTransaction> findBySenderAccountIdOrReceiverAccountId(String senderAccountId, String receiverAccountId);
    List<BankTransaction> findByAmountGreaterThan(double amount);
}
