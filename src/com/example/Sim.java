package com.example;

import java.util.List;

public class Sim {
    private static final int MAX_PER_STAT = 10;
    private static double energy;
    private static double hunger;
    private static double fun;
    private static double social;
    private static double hygiene;
    private static double bladder;
    private static boolean alive;
    private static List<Action> availableActions;
    private static Location currentLocation;

    public static double getEnergy() {
        return energy;
    }

    public static void setEnergy(double energy) {
        Sim.energy = energy;
    }

    public static double getHunger() {
        return hunger;
    }

    public static void setHunger(double hunger) {
        Sim.hunger = hunger;
    }

    public static double getFun() {
        return fun;
    }

    public static void setFun(double fun) {
        Sim.fun = fun;
    }

    public static double getSocial() {
        return social;
    }

    public static void setSocial(double social) {
        Sim.social = social;
    }

    public static double getHygiene() {
        return hygiene;
    }

    public static void setHygiene(double hygiene) {
        Sim.hygiene = hygiene;
    }

    public static double getBladder() {
        return bladder;
    }

    public static void setBladder(double bladder) {
        Sim.bladder = bladder;
    }

    public static boolean isAlive() {
        return energy > 0 && hunger > 0 && fun > 0 && social > 0 && hygiene > 0 && bladder > 0;
    }

    public static void setAlive(boolean alive) {
        Sim.alive = alive;
    }

    public static List<Action> getAvailableActions() {
        return availableActions;
    }

    public static void setAvailableActions(List<Action> availableActions) {
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

    public static void printStats() {
        System.out.println("Energy: " + energy);
        System.out.println("Hunger: " + hunger);
        System.out.println("Fun: " + fun);
        System.out.println("Social: " + social);
        System.out.println("Hygiene: " + hygiene);
        System.out.println("Bladder: " + bladder);
    }



}
