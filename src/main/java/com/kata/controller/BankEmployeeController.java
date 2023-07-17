package com.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kata.model.BankEmployee;
import com.kata.model.Position;
import com.kata.service.BankEmployeeService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/bank-employees")
public class BankEmployeeController {

    @Autowired
    private BankEmployeeService bankEmployeeService;

    @Autowired
    public BankEmployeeController(BankEmployeeService bankEmployeeService) {
        this.bankEmployeeService = bankEmployeeService;
    }

    @PostMapping
    public void saveBankEmployee(@RequestBody BankEmployee employee) {
        bankEmployeeService.saveBankEmployee(employee);
    }

    @GetMapping("/{id}")
    public BankEmployee getBankEmployeeById(@PathVariable String id) {
        return bankEmployeeService.getBankEmployeeById(id);
    }

    @GetMapping("/position/{position}")
    public List<BankEmployee> getBankEmployeesByPosition(@PathVariable Position position) {
        return bankEmployeeService.getBankEmployeesByPosition(position.toString());
    }

    @GetMapping("/name")
    public List<BankEmployee> getBankEmployeesByFirstNameOrLastName(
            @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        if (firstName != null && lastName != null) {
            return bankEmployeeService.getBankEmployeesByFirstNameAndLastName(firstName, lastName);
        } else if (firstName != null) {
            return bankEmployeeService.getBankEmployeesByFirstName(firstName);
        } else if (lastName != null) {
            return bankEmployeeService.getBankEmployeesByLastName(lastName);
        } else {
            return Collections.emptyList();
        }
    }
}
