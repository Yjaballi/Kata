package com.kata.model.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kata.model.BankAccount;

public class BankAccountEntityTest {

    @Test
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(100.0);
        double balance = bankAccount.getBalance();
        Assertions.assertEquals(100.0, balance);
    }

    @Test
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(100.0);
        bankAccount.withdraw(50.0);
        double balance = bankAccount.getBalance();
        Assertions.assertEquals(50.0, balance);
    }
}



