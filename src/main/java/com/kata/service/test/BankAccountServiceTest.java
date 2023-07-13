package com.kata.service.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kata.model.BankAccount;
import com.kata.repository.BankAccountRepository;
import com.kata.service.impl.BankAccountServiceImpl;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class BankAccountServiceTest {

    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private BankAccountServiceImpl bankAccountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveBankAccount() {
        // Create a BankAccount object
        BankAccount bankAccount = new BankAccount();
        // Set the properties of the BankAccount as needed
        bankAccount.setBalance(1000.0);

        // Mock the behavior of the bankAccountRepository.save method
        when(bankAccountRepository.save(bankAccount)).thenReturn(bankAccount);

        // Call the saveBankAccount method
        bankAccountService.saveBankAccount(bankAccount);

        // Verify that the bankAccountRepository.save method was called
        verify(bankAccountRepository, times(1)).save(bankAccount);
    }

    @Test
    public void testGetBankAccountById() {
        // Create a BankAccount object
        BankAccount bankAccount = new BankAccount();
        // Set the properties of the BankAccount as needed
        bankAccount.setId(1L);
        bankAccount.setBalance(1000.0);

        // Mock the behavior of the bankAccountRepository.findById method
        when(bankAccountRepository.findById(1L)).thenReturn(Optional.of(bankAccount));

        // Call the getBankAccountById method
        BankAccount result = bankAccountService.getBankAccountById(""+1L);

        // Verify that the bankAccountRepository.findById method was called
        verify(bankAccountRepository, times(1)).findById(1L);

        // Validate the result
        Assertions.assertEquals(bankAccount, result);
    }
}
