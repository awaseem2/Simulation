package com.example;

import java.util.ArrayList;

public abstract class Location {
    abstract String getName();

    abstract ArrayList<String> getActionsAvailable();

    abstract boolean isPlayerAtLocation();

    abstract void setPlayerAtLocation(boolean bool);

    abstract void nextEpoch();

    abstract void moveTo();
}
