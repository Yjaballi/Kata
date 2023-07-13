package com.kata.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double balance;
    
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private BankClient client;
    
    @OneToMany(mappedBy = "bankAccount")
    @JsonIgnore
    private List<BankOperation> operations;

    public BankAccount() {
        this.balance = 0.0;
        this.operations = new ArrayList<>();
    }

    public BankAccount(Long id) {
        this.id = id;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
            } else {
                throw new IllegalArgumentException("Insufficient balance");
            }
        } else {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }


   
    

    // Getters and Setters
    
    public List<BankOperation> getOperations() {
        return operations;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setOperations(List<BankOperation> operations) {
		this.operations = operations;
	}
    
	public BankClient getClient() {
        return client;
    }

    public void setClient(BankClient client) {
        this.client = client;
    }
    
    
}
