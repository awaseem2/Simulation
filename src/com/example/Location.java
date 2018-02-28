package com.example;

import java.util.ArrayList;

public abstract class Location {
    abstract String getName();

    /** Moves time forward and allows the sim to lose and increase stats randomly. */
    abstract void nextEpoch();

    /** Moves the Sim to the desired location. */
    abstract void moveTo(String location);
}
