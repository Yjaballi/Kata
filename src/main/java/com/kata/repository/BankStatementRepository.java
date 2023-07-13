package com.kata.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kata.model.BankAccount;
import com.kata.model.BankStatement;

public interface BankStatementRepository extends CrudRepository<BankStatement, Long> {
    //void save(BankStatement statement);
	Optional<BankStatement> findById(Long id);
    // Autres méthodes spécifiques si nécessaire
}

