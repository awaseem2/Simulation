package com.example;

import java.util.ArrayList;

public abstract class Location {
    abstract String getName();

    abstract boolean isPlayerAtLocation();

    abstract void setPlayerAtLocation(boolean bool);

    abstract void handleUserInput(String input);

    abstract void nextEpoch();

    abstract void moveTo();
}
