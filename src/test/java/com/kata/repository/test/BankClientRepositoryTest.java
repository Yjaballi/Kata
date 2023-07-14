package com.kata.repository.test;

import com.kata.model.BankClient;
import com.kata.repository.BankClientRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class BankClientRepositoryTest {

    @Autowired
    private BankClientRepository bankClientRepository;

    @Test
    public void testFindById() {
        // Arrange
        BankClient bankClient = new BankClient("John", "Doe", "johndoe@example.com");
        BankClient savedClient = bankClientRepository.save(bankClient);

        // Act
        Optional<BankClient> retrievedClient = bankClientRepository.findById(savedClient.getId());

        // Assert
        Assertions.assertTrue(retrievedClient.isPresent());
        Assertions.assertEquals(savedClient.getId(), retrievedClient.get().getId());
        Assertions.assertEquals(savedClient.getFirstName(), retrievedClient.get().getFirstName());
        Assertions.assertEquals(savedClient.getLastName(), retrievedClient.get().getLastName());
        Assertions.assertEquals(savedClient.getEmail(), retrievedClient.get().getEmail());
    }

    @Test
    public void testFindByLastName() {
        // Arrange
        BankClient bankClient1 = new BankClient("John", "Doe", "johndoe@example.com");
        BankClient bankClient2 = new BankClient("Jane", "Doe", "janedoe@example.com");
        bankClientRepository.save(bankClient1);
        bankClientRepository.save(bankClient2);

        // Act
        List<BankClient> retrievedClients = bankClientRepository.findByLastName("Doe");

        // Assert
        Assertions.assertEquals(2, retrievedClients.size());
    }

    @Test
    public void testFindByEmailContaining() {
        // Arrange
        BankClient bankClient1 = new BankClient("John", "Doe", "johndoe@example.com");
        BankClient bankClient2 = new BankClient("Jane", "Doe", "janedoe@example.com");
        bankClientRepository.save(bankClient1);
        bankClientRepository.save(bankClient2);

        // Act
        List<BankClient> retrievedClients = bankClientRepository.findByEmailContaining("john");

        // Assert
        Assertions.assertEquals(1, retrievedClients.size());
        Assertions.assertTrue(retrievedClients.get(0).getEmail().contains("john"));
    }
}
