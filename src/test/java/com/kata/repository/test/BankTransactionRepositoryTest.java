package com.kata.repository.test;

import com.kata.model.BankTransaction;
import com.kata.repository.BankTransactionRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
public class BankTransactionRepositoryTest {

    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    @Test
    public void testFindBySenderAccountIdOrReceiverAccountId() {
        // Create sample BankTransaction objects and save them in the repository
        BankTransaction transaction1 = new BankTransaction(null, 100.0, "123456", "987654");
        BankTransaction transaction2 = new BankTransaction(null, 200.0, "123456", "567890");
        BankTransaction transaction3 = new BankTransaction(null, 300.0, "345678", "987654");
        bankTransactionRepository.saveAll(Arrays.asList(transaction1, transaction2, transaction3));

        // Retrieve the BankTransactions from the repository using findBySenderAccountIdOrReceiverAccountId
        List<BankTransaction> retrievedTransactions = bankTransactionRepository.findBySenderAccountIdOrReceiverAccountId("123456", "987654");

        // Validate that the retrievedTransactions list contains the expected number of BankTransactions
        Assertions.assertEquals(3, retrievedTransactions.size());
    }

    @Test
    public void testFindByAmountGreaterThan() {
        // Create sample BankTransaction objects and save them in the repository
        BankTransaction transaction1 = new BankTransaction(null, 100.0, "123456", "987654");
        BankTransaction transaction2 = new BankTransaction(null, 200.0, "123456", "567890");
        BankTransaction transaction3 = new BankTransaction(null, 300.0, "345678", "987654");
        bankTransactionRepository.saveAll(Arrays.asList(transaction1, transaction2, transaction3));

        // Retrieve the BankTransactions from the repository using findByAmountGreaterThan
        List<BankTransaction> retrievedTransactions = bankTransactionRepository.findByAmountGreaterThan(150.0);

        // Validate that the retrievedTransactions list contains the expected number of BankTransactions
        Assertions.assertEquals(2, retrievedTransactions.size());
    }
}
