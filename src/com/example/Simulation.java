package com.example;

import com.google.gson.Gson;

public class Simulation {

    public static void main(String[] args) {
        Gson gson = new Gson();
        Simsville.setSimsGame(gson.fromJson(DataManager.getFileContentsAsString(
                "Actions.json"), SimsGame.class));
        Simsville.getSimsGame().initializeSimulation();
        Simsville.getSimsGame().runSimulation();
    }
}
