package com.example;

import java.util.ArrayList;

public class Work extends Location {
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
        this.playerAtLocation = playerAtLocation;
    }

    @Override
    void nextEpoch() {

    }

    @Override
    void moveTo(String location) {

    }
}
