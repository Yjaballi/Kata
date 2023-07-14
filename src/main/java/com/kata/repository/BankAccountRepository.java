package com.kata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.kata.model.BankAccount;
import com.kata.model.BankClient;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
    Optional<BankAccount> findById(Long id);
    List<BankAccount> findByClient(BankClient client);
    List<BankAccount> findByBalanceGreaterThan(double amount);
}
