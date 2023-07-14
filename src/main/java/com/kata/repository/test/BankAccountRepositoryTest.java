package com.kata.repository.test;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.kata.model.BankAccount;
import com.kata.model.BankClient;
import com.kata.repository.BankAccountRepository;
import com.kata.repository.BankClientRepository;

@DataJpaTest
public class BankAccountRepositoryTest {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankClientRepository bankClientRepository;

    @Test
    public void testFindById() {
        // Create a BankAccount object to save in the repository
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(1000.0);
        bankAccountRepository.save(bankAccount);

        // Retrieve the BankAccount from the repository using findById
        Long bankAccountId = bankAccount.getId();
        Optional<BankAccount> retrievedAccount = bankAccountRepository.findById(bankAccountId);

        // Validate that the retrievedAccount is present and has the expected balance
        Assertions.assertTrue(retrievedAccount.isPresent());
        Assertions.assertEquals(1000.0, retrievedAccount.get().getBalance());
    }

    @Test
    public void testFindByClient() {
        // Create a BankClient object and save it in the repository
        BankClient bankClient = new BankClient();
        // Set the properties of the BankClient as needed
        bankClient.setFirstName("Youssef");
        bankClient.setLastName("Jabali");
        bankClient.setEmail("jaballiyoussef4@gmail.com");
        bankClientRepository.save(bankClient);

        // Create BankAccount objects associated with the BankClient
        BankAccount account1 = new BankAccount();
        account1.setBalance(1000.0);
        account1.setClient(bankClient);
        bankAccountRepository.save(account1);

        BankAccount account2 = new BankAccount();
        account2.setBalance(2000.0);
        account2.setClient(bankClient);
        bankAccountRepository.save(account2);

        // Retrieve the list of BankAccounts associated with the BankClient using findByClient
        List<BankAccount> accountsByClient = bankAccountRepository.findByClient(bankClient);

        // Validate that the accountsByClient list contains the expected number of BankAccounts
        Assertions.assertEquals(2, accountsByClient.size());
    }

}
