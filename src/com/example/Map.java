package com.example;

public class Map {
    private static SimsGame simsGame = new SimsGame();

    public static SimsGame getSimsGame() {
        return simsGame;
    }

    public static void setSimsGame(SimsGame simsGame) {
        Map.simsGame = simsGame;
    }
}
