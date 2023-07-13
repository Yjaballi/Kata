package com.kata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date date;
    private double amount;
    private String senderAccountId;
    private String receiverAccountId;

    public BankTransaction() {
    }

    public BankTransaction(Date date, double amount, String senderAccountId, String receiverAccountId) {
        this.date = date;
        this.amount = amount;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
    }

	

    // Getters and Setters
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSenderAccountId() {
		return senderAccountId;
	}

	public void setSenderAccountId(String senderAccountId) {
		this.senderAccountId = senderAccountId;
	}

	public String getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(String receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}
    
}
