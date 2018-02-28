package com.example;

import com.google.gson.Gson;

public class Simulation {

    public static void main(String[] args) {
        Gson gson = new Gson();
        Map.setSimsGame(gson.fromJson(UtilityFunctions.getFileContentsAsString(
                "Actions.json"), SimsGame.class));
        Map.getSimsGame().initializeSimulation();
        Map.getSimsGame().runSimulation();
    }
}
