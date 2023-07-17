package com.kata.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BankEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Position position;

    
    
    @OneToMany(mappedBy = "bankEmployee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BankAccount> bankAccounts;
    
    @OneToMany(mappedBy = "bankEmployee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BankOperation> bankOperations;

    @OneToMany(mappedBy = "bankEmployee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BankTransaction> bankTransactions;

    public BankEmployee() {
    }

    public BankEmployee(String firstName, String lastName, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankOperation> getBankOperations() {
        return bankOperations;
    }

    public void setBankOperations(List<BankOperation> bankOperations) {
        this.bankOperations = bankOperations;
    }

    public List<BankTransaction> getBankTransactions() {
        return bankTransactions;
    }

    public void setBankTransactions(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
}
