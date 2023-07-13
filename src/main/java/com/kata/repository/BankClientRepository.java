package com.kata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kata.model.BankClient;
@Repository
public interface BankClientRepository extends CrudRepository<BankClient, Long> {
    //void save(BankClient client);
    Optional<BankClient> findById(Long id);
    List<BankClient> findByLastName(String lastName);
    List<BankClient> findByEmailContaining(String email);
    // Autres méthodes spécifiques si nécessaire
}

