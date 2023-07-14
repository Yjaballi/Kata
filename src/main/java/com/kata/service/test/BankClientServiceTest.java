package com.kata.service.test;

import com.kata.model.BankClient;
import com.kata.repository.BankClientRepository;
import com.kata.service.BankClientService;
import com.kata.service.impl.BankClientServiceImpl;
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
public class BankClientServiceTest {

    @Mock
    private BankClientRepository bankClientRepository;

    @InjectMocks
    private BankClientServiceImpl bankClientService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveBankClient() {
        // Create a BankClient object
        BankClient bankClient = new BankClient();
        // Set the properties of the BankClient as needed
        bankClient.setFirstName("John");
        bankClient.setLastName("Doe");
        bankClient.setEmail("johndoe@example.com");

        // Mock the behavior of the bankClientRepository.save method
        when(bankClientRepository.save(bankClient)).thenReturn(bankClient);

        // Call the saveBankClient method
        bankClientService.saveBankClient(bankClient);

        // Verify that the bankClientRepository.save method was called
        verify(bankClientRepository, times(1)).save(bankClient);
    }

    @Test
    public void testGetBankClientById() {
        // Create a BankClient object
        BankClient bankClient = new BankClient();
        // Set the properties of the BankClient as needed
        bankClient.setId(1L);
        bankClient.setFirstName("John");
        bankClient.setLastName("Doe");
        bankClient.setEmail("johndoe@example.com");

        // Mock the behavior of the bankClientRepository.findById method
        when(bankClientRepository.findById(1L)).thenReturn(Optional.of(bankClient));

        // Call the getBankClientById method
        BankClient result = bankClientService.getBankClientById("" + 1L);

        // Verify that the bankClientRepository.findById method was called
        verify(bankClientRepository, times(1)).findById(1L);

        // Validate the result
        Assertions.assertEquals(bankClient, result);
    }

    @Test
    public void testGetBankClientsByLastName() {
        // Create a sample list of BankClient objects
        BankClient bankClient1 = new BankClient();
        bankClient1.setId(1L);
        bankClient1.setFirstName("John");
        bankClient1.setLastName("Doe");
        bankClient1.setEmail("johndoe@example.com");

        BankClient bankClient2 = new BankClient();
        bankClient2.setId(2L);
        bankClient2.setFirstName("Jane");
        bankClient2.setLastName("Doe");
        bankClient2.setEmail("janedoe@example.com");

        List<BankClient> bankClients = Arrays.asList(bankClient1, bankClient2);

        // Mock the behavior of the bankClientRepository.findByLastName method
        when(bankClientRepository.findByLastName("Doe")).thenReturn(bankClients);

        // Call the getBankClientsByLastName method
        List<BankClient> result = bankClientService.getBankClientsByLastName("Doe");

        // Verify that the bankClientRepository.findByLastName method was called
        verify(bankClientRepository, times(1)).findByLastName("Doe");

        // Validate the result
        Assertions.assertEquals(bankClients, result);
    }

    @Test
    public void testGetBankClientsByEmailContaining() {
        // Create a sample list of BankClient objects
        BankClient bankClient1 = new BankClient();
        bankClient1.setId(1L);
        bankClient1.setFirstName("John");
        bankClient1.setLastName("Doe");
        bankClient1.setEmail("johndoe@example.com");

        BankClient bankClient2 = new BankClient();
        bankClient2.setId(2L);
        bankClient2.setFirstName("Jane");
        bankClient2.setLastName("Doe");
        bankClient2.setEmail("janedoe@example.com");

        List<BankClient> bankClients = Arrays.asList(bankClient1, bankClient2);

        // Mock the behavior of the bankClientRepository.findByEmailContaining method
        when(bankClientRepository.findByEmailContaining("john")).thenReturn(bankClients);

        // Call the getBankClientsByEmailContaining method
        List<BankClient> result = bankClientService.getBankClientsByEmailContaining("john");

        // Verify that the bankClientRepository.findByEmailContaining method was called
        verify(bankClientRepository, times(1)).findByEmailContaining("john");

        // Validate the result
        Assertions.assertEquals(bankClients, result);
    }
}
