package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Home extends Location {
    private ArrayList<String> actionsAvailable = new ArrayList<>(Arrays.asList("sleep", "cook",
            "watch tv", "call", "call", "use toilet", "shower", "brush teeth", "read book"));
    private String name = "home";
    private boolean playerAtLocation = false;

    public ArrayList<String> getActionsAvailable() {
        return actionsAvailable;
    }

    public String getName() {
        return name;
    }

    public boolean isPlayerAtLocation() {
        return playerAtLocation;
    }

    public void setPlayerAtLocation(boolean playerAtLocation) {
        this.playerAtLocation = playerAtLocation;
    }

    @Override
    public void nextEpoch() {

    }

    @Override
    void moveTo() {

    }
}
