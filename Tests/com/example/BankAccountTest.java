package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {
    BankAccount bankAccount = new BankAccount();

    @Test
    public void getSimoleons() {
        bankAccount.setSimoleons(200);
        assertEquals(200, bankAccount.getSimoleons());
    }
}