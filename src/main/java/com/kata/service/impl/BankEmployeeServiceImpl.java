package com.kata.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.BankEmployee;
import com.kata.repository.BankEmployeeRepository;
import com.kata.service.BankEmployeeService;
import com.kata.exception.InvalidIdException;
import com.kata.exception.NullObjectException;

@Service
public class BankEmployeeServiceImpl implements BankEmployeeService {
	
	@Autowired
    private BankEmployeeRepository bankEmployeeRepository;


    @Override
    public void saveBankEmployee(BankEmployee employee) {
    	if (employee == null) {
            throw new NullObjectException("MISSING BANK EMPLOYE");
        }
        bankEmployeeRepository.save(employee);
    }

    @Override
    public BankEmployee getBankEmployeeById(String id) {
        Optional<BankEmployee> optionalEmployee = bankEmployeeRepository.findById(Long.parseLong(id));
        return optionalEmployee.orElseThrow(() -> new InvalidIdException("Invalid bank employee ID: " + id));
    }


    @Override
    public List<BankEmployee> getBankEmployeesByPosition(String position) {
    	if (position == null) {
            throw new NullObjectException("MISSING POSITION");
        }
        return bankEmployeeRepository.findByPosition(position);
    }

    @Override
    public List<BankEmployee> getBankEmployeesByFirstNameOrLastName(String firstName, String lastName) {
    	if(firstName == null && lastName == null) {
            throw new NullObjectException("MISSING FIRSTNAME AND LASTNAME");
    	}
        return bankEmployeeRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public List<BankEmployee> getBankEmployeesByFirstNameAndLastName(String firstName, String lastName) {
    	if(firstName == null) {
            throw new NullObjectException("MISSING FIRSTNAME");
    	}
    	else if(lastName == null) {
    		throw new NullObjectException("MISSING LASTNAME");
    	}
    	return bankEmployeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<BankEmployee> getBankEmployeesByFirstName(String firstName) {
    	if(firstName == null) {
            throw new NullObjectException("MISSING FIRSTNAME");
    	}
        return bankEmployeeRepository.findByFirstName(firstName);
    }

    @Override
    public List<BankEmployee> getBankEmployeesByLastName(String lastName) {
    	if(lastName == null) {
            throw new NullObjectException("MISSING FIRSTNAME");
    	}
        return bankEmployeeRepository.findByLastName(lastName);
    }
}
