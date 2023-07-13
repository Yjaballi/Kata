package com.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kata.model.BankClient;
import com.kata.service.BankClientService;

import java.util.List;

@RestController
@RequestMapping("/bank-clients")
public class BankClientController {
	
	@Autowired 
    private BankClientService bankClientService;

    @Autowired 
    public BankClientController(BankClientService bankClientService) {
        this.bankClientService = bankClientService;
    }

    @PostMapping
    public void saveBankClient(@RequestBody BankClient client) {
        bankClientService.saveBankClient(client);
    }

    @GetMapping("/{id}")
    public BankClient getBankClientById(@PathVariable String id) {
        return bankClientService.getBankClientById(id);
    }

    @GetMapping("/last-name/{lastName}")
    public List<BankClient> getBankClientsByLastName(@PathVariable String lastName) {
        return bankClientService.getBankClientsByLastName(lastName);
    }

    @GetMapping("/email-containing")
    public List<BankClient> getBankClientsByEmailContaining(@RequestParam String email) {
        return bankClientService.getBankClientsByEmailContaining(email);
    }
}
