package com.example;
import java.util.*;

public class Home extends Location {
    private String name = "home";
    private boolean playerAtLocation = false;


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
        NextEpochManager.handleNextEpoch();

    }

    @Override
    void moveTo(String location) {


    }
}
