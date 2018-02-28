package com.example;

public class BankAccount extends Thing {
    private int simoleons;


    @Override
    public int getSimoleons() {
        return simoleons;
    }

    public void setSimoleons(int simoleons) {
        this.simoleons = simoleons;
    }
}
