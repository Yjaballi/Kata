package com.kata.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kata.model.BankAccount;
import com.kata.model.BankOperation;

public interface BankOperationRepository extends CrudRepository<BankOperation, Long> {
    //void save(BankOperation operation);
    List<BankOperation> findByBankAccount(BankAccount bankAccount);
    List<BankOperation> findByBankAccountAndDateBetween(BankAccount bankAccount, Date startDate, Date endDate);
    List<BankOperation> findByBankAccountOrderByDateDesc(BankAccount bankAccount);
    // Autres méthodes spécifiques si nécessaire
}

