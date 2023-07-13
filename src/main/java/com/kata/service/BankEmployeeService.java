package com.kata.service;

import java.util.List;

import com.kata.model.BankEmployee;

public interface BankEmployeeService {
    void saveBankEmployee(BankEmployee employee);
    BankEmployee getBankEmployeeById(String id);
    List<BankEmployee> getBankEmployeesByPosition(String position);
    List<BankEmployee> getBankEmployeesByFirstNameOrLastName(String firstName, String lastName);
	List<BankEmployee> getBankEmployeesByFirstNameAndLastName(String firstName, String lastName);
	List<BankEmployee> getBankEmployeesByFirstName(String firstName);
	List<BankEmployee> getBankEmployeesByLastName(String lastName);
}

