package com.kata.service;

import java.util.List;

import com.kata.model.BankClient;

public interface BankClientService {
    void saveBankClient(BankClient client);
    BankClient getBankClientById(String id);
    List<BankClient> getBankClientsByLastName(String lastName);
    List<BankClient> getBankClientsByEmailContaining(String email);
}
