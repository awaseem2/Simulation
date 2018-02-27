package com.example;

import java.util.HashMap;

public class Player {
    private static final int MAX_PER_STAT = 10;
    private static int energy;
    private static int hunger;
    private static int fun;
    private static int social;
    private static int hygiene;
    private static int bladder;
    private static String currentLocation;
   private static HashMap<String, Location> locationsMap = new HashMap<>();


    public static int getEnergy() {
        return energy;
    }

    public static void setEnergy(int energy) {
        Player.energy = energy;
    }

    public static int getHunger() {
        return hunger;
    }

    public static void setHunger(int hunger) {
        Player.hunger = hunger;
    }

    public static int getFun() {
        return fun;
    }

    public static void setFun(int fun) {
        Player.fun = fun;
    }

    public static int getSocial() {
        return social;
    }

    public static void setSocial(int social) {
        Player.social = social;
    }

    public static int getHygiene() {
        return hygiene;
    }

    public static void setHygiene(int hygiene) {
        Player.hygiene = hygiene;
    }

    public static int getBladder() {
        return bladder;
    }

    public static void setBladder(int bladder) {
        Player.bladder = bladder;
    }

    public static String getCurrentLocation() {
        return currentLocation;
    }

    public static void setCurrentLocation(String currentLocation) {
        Player.currentLocation = currentLocation;
    }

    public static HashMap<String, Location> getLocationsMap() {
        return locationsMap;
    }

    public static void initializeLocations(Home home, Work work, Park park) {
        locationsMap.put("home", home);
        locationsMap.put("work", work);
        locationsMap.put("park", park);
    }

    public static void setStatsToFull() {
        Player.energy = MAX_PER_STAT;
        Player.fun = MAX_PER_STAT;
        Player.hunger = MAX_PER_STAT;
        Player.hygiene = MAX_PER_STAT;
        Player.bladder = MAX_PER_STAT;
        Player.social = MAX_PER_STAT;

    }

}
