package com.kata.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kata.model.BankTransaction;

import java.util.Date;

public class BankTransactionTest {

    @Test
    public void testBankTransactionCreation() {
        // Arrange
        Long id = 1L;
        Date date = new Date();
        double amount = 100.0;
        String senderAccountId = "123456789";
        String receiverAccountId = "987654321";

        // Act
        BankTransaction bankTransaction = new BankTransaction(date, amount, senderAccountId, receiverAccountId);
        bankTransaction.setId(id);

        // Assert
        Assertions.assertEquals(id, bankTransaction.getId());
        Assertions.assertEquals(date, bankTransaction.getDate());
        Assertions.assertEquals(amount, bankTransaction.getAmount());
        Assertions.assertEquals(senderAccountId, bankTransaction.getSenderAccountId());
        Assertions.assertEquals(receiverAccountId, bankTransaction.getReceiverAccountId());
    }

    @Test
    public void testBankTransactionSetters() {
        // Arrange
        BankTransaction bankTransaction = new BankTransaction();
        Long id = 1L;
        Date date = new Date();
        double amount = 100.0;
        String senderAccountId = "123456789";
        String receiverAccountId = "987654321";

        // Act
        bankTransaction.setId(id);
        bankTransaction.setDate(date);
        bankTransaction.setAmount(amount);
        bankTransaction.setSenderAccountId(senderAccountId);
        bankTransaction.setReceiverAccountId(receiverAccountId);

        // Assert
        Assertions.assertEquals(id, bankTransaction.getId());
        Assertions.assertEquals(date, bankTransaction.getDate());
        Assertions.assertEquals(amount, bankTransaction.getAmount());
        Assertions.assertEquals(senderAccountId, bankTransaction.getSenderAccountId());
        Assertions.assertEquals(receiverAccountId, bankTransaction.getReceiverAccountId());
    }
}
