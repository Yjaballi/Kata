package com.kata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class BankStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private Date date;

    
   
    
    @OneToMany
    private List<BankOperation> operations;

    public BankStatement() {
    }

    public BankStatement(List<BankOperation> operations, Date date) {
        this.operations = operations;
        this.date = date;
    }

	
    // Getters and Setters
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public List<BankOperation> getOperations() {
		return operations;
	}

	public void setOperations(List<BankOperation> operations) {
		this.operations = operations;
	}
	
	public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
