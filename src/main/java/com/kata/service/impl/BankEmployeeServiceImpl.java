package com.kata.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.BankEmployee;
import com.kata.repository.BankEmployeeRepository;
import com.kata.service.BankEmployeeService;
import com.kata.exception.InvalidIdException;

@Service
public class BankEmployeeServiceImpl implements BankEmployeeService {
	
	@Autowired
    private BankEmployeeRepository bankEmployeeRepository;


    @Override
    public void saveBankEmployee(BankEmployee employee) {
        bankEmployeeRepository.save(employee);
    }

    @Override
    public BankEmployee getBankEmployeeById(String id) {
        Optional<BankEmployee> optionalEmployee = bankEmployeeRepository.findById(Long.parseLong(id));
        return optionalEmployee.orElseThrow(() -> new InvalidIdException("Invalid bank employee ID: " + id));
    }


    @Override
    public List<BankEmployee> getBankEmployeesByPosition(String position) {
        return bankEmployeeRepository.findByPosition(position);
    }

    @Override
    public List<BankEmployee> getBankEmployeesByFirstNameOrLastName(String firstName, String lastName) {
        return bankEmployeeRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public List<BankEmployee> getBankEmployeesByFirstNameAndLastName(String firstName, String lastName) {
        return bankEmployeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<BankEmployee> getBankEmployeesByFirstName(String firstName) {
        return bankEmployeeRepository.findByFirstName(firstName);
    }

    @Override
    public List<BankEmployee> getBankEmployeesByLastName(String lastName) {
        return bankEmployeeRepository.findByLastName(lastName);
    }
}
