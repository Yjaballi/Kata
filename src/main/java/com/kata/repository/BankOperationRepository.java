package com.kata.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kata.model.BankAccount;
import com.kata.model.BankOperation;

@Repository
public interface BankOperationRepository extends CrudRepository<BankOperation, Long> {
    List<BankOperation> findByBankAccount(BankAccount bankAccount);
    List<BankOperation> findByBankAccountAndDateBetween(BankAccount bankAccount, Date startDate, Date endDate);
    List<BankOperation> findByBankAccountOrderByDateDesc(BankAccount bankAccount);
}

