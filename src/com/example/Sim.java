package com.example;

import java.util.ArrayList;
import java.util.List;

public class Sim {
    private static final int MAX_PER_STAT = 10;
    private static int energy;
    private static int hunger;
    private static int fun;
    private static int social;
    private static int hygiene;
    private static int bladder;
    private static boolean alive;
    private static ArrayList<Action> availableActions;
    private static Location currentLocation;

    public static int getEnergy() {
        return energy;
    }

    public static void setEnergy(int energy) {
        Sim.energy = energy;
    }

    public static int getHunger() {
        return hunger;
    }

    public static void setHunger(int hunger) {
        Sim.hunger = hunger;
    }

    public static int getFun() {
        return fun;
    }

    public static void setFun(int fun) {
        Sim.fun = fun;
    }

    public static int getSocial() {
        return social;
    }

    public static void setSocial(int social) {
        Sim.social = social;
    }

    public static int getHygiene() {
        return hygiene;
    }

    public static void setHygiene(int hygiene) {
        Sim.hygiene = hygiene;
    }

    public static int getBladder() {
        return bladder;
    }

    public static void setBladder(int bladder) {
        Sim.bladder = bladder;
    }

    public static boolean isAlive() {
        return alive;
    }

    public static void setAlive(boolean alive) {
        Sim.alive = alive;
    }

    public static ArrayList<Action> getAvailableActions() {
        return availableActions;
    }

    public static void setAvailableActions(ArrayList<Action> availableActions) {
        Sim.availableActions = availableActions;
    }

    public static Location getCurrentLocation() {
        return currentLocation;
    }

    public static void setCurrentLocation(Location currentLocation) {
        Sim.currentLocation = currentLocation;
    }

    public static void setStatsToFull() {
        Sim.energy = MAX_PER_STAT;
        Sim.fun = MAX_PER_STAT;
        Sim.hunger = MAX_PER_STAT;
        Sim.hygiene = MAX_PER_STAT;
        Sim.bladder = MAX_PER_STAT;
        Sim.social = MAX_PER_STAT;

    }



}
