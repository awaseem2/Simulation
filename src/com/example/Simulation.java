package com.example;

import com.google.gson.Gson;

public class Simulation {

    public static void main(String[] args) {
        SimsGame simsGame = new SimsGame();
        Gson gson = new Gson();
        gson.fromJson(UtilityFunctions.getFileContentsAsString("Actions.json"), SimsGame.class);
        simsGame.initializeSimulation();
        simsGame.runSimulation();
    }
}
