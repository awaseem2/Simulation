package com.example;

public class Simsville {
    private static SimsGame simsGame = new SimsGame();

    public static SimsGame getSimsGame() {
        return simsGame;
    }

    public static void setSimsGame(SimsGame simsGame) {
        Simsville.simsGame = simsGame;
    }
}
