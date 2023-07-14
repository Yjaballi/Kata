package com.kata.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kata.model.BankAccount;
import com.kata.model.BankStatement;

@Repository
public interface BankStatementRepository extends CrudRepository<BankStatement, Long> {
	Optional<BankStatement> findById(Long id);
}

