package com.example;

import java.util.ArrayList;

public class Park extends Location {

    private String name = "work";
    private boolean playerAtLocation = false;


    @Override
    String getName() {
        return name;
    }

    @Override
    boolean isPlayerAtLocation() {
        return playerAtLocation;
    }

    @Override
    void setPlayerAtLocation(boolean bool) {
        playerAtLocation = bool;
    }

    @Override
    void nextEpoch() {

    }

    @Override
    void moveTo(String location) {

    }
}
