package com.kata.model.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kata.model.BankClient;

public class BankClientEntityTest {

    @Test
    public void testBankClientCreation() {
        // Arrange
        Long id = 1L;
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@example.com";
        
        // Act
        BankClient bankClient = new BankClient(firstName, lastName, email);
        
        // Assert
        Assertions.assertEquals(firstName, bankClient.getFirstName());
        Assertions.assertEquals(lastName, bankClient.getLastName());
        Assertions.assertEquals(email, bankClient.getEmail());
    }
    
    @Test
    public void testBankClientSetters() {
        // Arrange
        BankClient bankClient = new BankClient();
        Long id = 1L;
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@example.com";
        
        // Act
        bankClient.setId(id);
        bankClient.setFirstName(firstName);
        bankClient.setLastName(lastName);
        bankClient.setEmail(email);
        
        // Assert
        Assertions.assertEquals(id, bankClient.getId());
        Assertions.assertEquals(firstName, bankClient.getFirstName());
        Assertions.assertEquals(lastName, bankClient.getLastName());
        Assertions.assertEquals(email, bankClient.getEmail());
    }
}

