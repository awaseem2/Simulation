package com.example;

public class BankAccount extends Thing {
    private static int totalSimoleons;

    public static int getTotalSimoleons() {
        return totalSimoleons;
    }

    public static void setTotalSimoleons(int totalSimoleons) {
        BankAccount.totalSimoleons = totalSimoleons;
    }
}
