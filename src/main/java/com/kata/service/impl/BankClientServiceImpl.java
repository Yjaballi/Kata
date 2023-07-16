package com.kata.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.exception.InvalidIdException;
import com.kata.exception.NullObjectException;
import com.kata.model.BankClient;
import com.kata.repository.BankClientRepository;
import com.kata.service.BankClientService;

@Service
public class BankClientServiceImpl implements BankClientService {
	
	@Autowired
    private BankClientRepository bankClientRepository;


    @Override
    public void saveBankClient(BankClient client) {
    	if (client == null) {
            throw new NullObjectException("MISSING BANK CLIENT");
        }
        bankClientRepository.save(client);
    }

    @Override
    public BankClient getBankClientById(String id) {
        Optional<BankClient> optionalClient = bankClientRepository.findById(Long.parseLong(id));
        return optionalClient.orElseThrow(() -> new InvalidIdException("Invalid bank client ID: " + id));
    }


    @Override
    public List<BankClient> getBankClientsByLastName(String lastName) {
    	if (lastName == null) {
            throw new NullObjectException("MISSING LASTNAME");
        }
        return bankClientRepository.findByLastName(lastName);
    }

    @Override
    public List<BankClient> getBankClientsByEmailContaining(String email) {
    	if (email == null) {
            throw new NullObjectException("MISSING EMAIL");
        }
        return bankClientRepository.findByEmailContaining(email);
    }
}
