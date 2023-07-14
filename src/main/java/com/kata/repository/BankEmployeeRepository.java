package com.kata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kata.model.BankEmployee;

@Repository
public interface BankEmployeeRepository extends CrudRepository<BankEmployee, Long> {
    Optional<BankEmployee> findById(Long id);
    List<BankEmployee> findByPosition(String position);
    List<BankEmployee> findByFirstNameOrLastName(String firstName, String lastName);
    List<BankEmployee> findByFirstNameAndLastName(String firstName, String lastName);
    List<BankEmployee> findByFirstName(String firstName);
    List<BankEmployee> findByLastName(String lastName);
}
