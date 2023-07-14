package com.kata.service.test;

import com.kata.model.BankTransaction;
import com.kata.repository.BankTransactionRepository;
import com.kata.service.BankTransactionService;
import com.kata.service.impl.BankTransactionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BankTransactionServiceTest {

    @Mock
    private BankTransactionRepository bankTransactionRepository;

    @InjectMocks
    private BankTransactionServiceImpl bankTransactionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveBankTransaction() {
        // Create a BankTransaction object
        BankTransaction bankTransaction = new BankTransaction();
        // Set the properties of the BankTransaction as needed
        bankTransaction.setAmount(1000.0);

        // Mock the behavior of the bankTransactionRepository.save method
        when(bankTransactionRepository.save(bankTransaction)).thenReturn(bankTransaction);

        // Call the saveBankTransaction method
        bankTransactionService.saveBankTransaction(bankTransaction);

        // Verify that the bankTransactionRepository.save method was called
        verify(bankTransactionRepository, times(1)).save(bankTransaction);
    }

    @Test
    public void testGetBankTransactionsBySenderAccountIdOrReceiverAccountId() {
        // Create a sample list of BankTransaction objects
        BankTransaction bankTransaction1 = new BankTransaction();
        bankTransaction1.setId(1L);
        bankTransaction1.setAmount(100.0);
        bankTransaction1.setSenderAccountId("123456");
        bankTransaction1.setReceiverAccountId("987654");

        BankTransaction bankTransaction2 = new BankTransaction();
        bankTransaction2.setId(2L);
        bankTransaction2.setAmount(200.0);
        bankTransaction2.setSenderAccountId("123456");
        bankTransaction2.setReceiverAccountId("567890");

        List<BankTransaction> bankTransactions = Arrays.asList(bankTransaction1, bankTransaction2);

        // Mock the behavior of the bankTransactionRepository.findBySenderAccountIdOrReceiverAccountId method
        when(bankTransactionRepository.findBySenderAccountIdOrReceiverAccountId("123456", "987654")).thenReturn(bankTransactions);

        // Call the getBankTransactionsBySenderAccountIdOrReceiverAccountId method
        List<BankTransaction> result = bankTransactionService.getBankTransactionsBySenderAccountIdOrReceiverAccountId("123456", "987654");

        // Verify that the bankTransactionRepository.findBySenderAccountIdOrReceiverAccountId method was called
        verify(bankTransactionRepository, times(1)).findBySenderAccountIdOrReceiverAccountId("123456", "987654");

        // Validate the result
        Assertions.assertEquals(bankTransactions, result);
    }

    @Test
    public void testGetBankTransactionsByAmountGreaterThan() {
        // Create a sample list of BankTransaction objects
        BankTransaction bankTransaction1 = new BankTransaction();
        bankTransaction1.setId(1L);
        bankTransaction1.setAmount(100.0);
        bankTransaction1.setSenderAccountId("123456");
        bankTransaction1.setReceiverAccountId("987654");

        BankTransaction bankTransaction2 = new BankTransaction();
        bankTransaction2.setId(2L);
        bankTransaction2.setAmount(200.0);
        bankTransaction2.setSenderAccountId("123456");
        bankTransaction2.setReceiverAccountId("567890");

        List<BankTransaction> bankTransactions = Arrays.asList(bankTransaction1, bankTransaction2);

        // Mock the behavior of the bankTransactionRepository.findByAmountGreaterThan method
        when(bankTransactionRepository.findByAmountGreaterThan(150.0)).thenReturn(bankTransactions);

        // Call the getBankTransactionsByAmountGreaterThan method
        List<BankTransaction> result = bankTransactionService.getBankTransactionsByAmountGreaterThan(150.0);

        // Verify that the bankTransactionRepository.findByAmountGreaterThan method was called
        verify(bankTransactionRepository, times(1)).findByAmountGreaterThan(150.0);

        // Validate the result
        Assertions.assertEquals(bankTransactions, result);
    }
}
