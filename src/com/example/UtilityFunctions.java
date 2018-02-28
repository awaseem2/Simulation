package com.example;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class UtilityFunctions {
    private static String currentLocation;
    private static final int MAX_PER_STAT = 10;
    private static HashMap<String, Location> locationsMap = new HashMap<>();

    public static String getCurrentLocation() {
        return currentLocation;
    }

    public static void setCurrentLocation(String currentLocation) {
        UtilityFunctions.currentLocation = currentLocation;
    }

    public static HashMap<String, Location> getLocationsMap() {
        return locationsMap;
    }

    /** Converts the file name to a parsable file.
     *
     * @param filename The name of the file desired to be used.
     * @return a String of the contents of the file.
     */
    public static String getFileContentsAsString(String filename) {
        final Path path = FileSystems.getDefault().getPath("data", filename);
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            System.out.println("Couldn't find file: " + filename);
            System.exit(-1);
            return null;
        }
    }

    public static void initializeLocations(Home home, Work work, Park park) {
        locationsMap.put("home", home);
        locationsMap.put("work", work);
        locationsMap.put("park", park);
    }

    public static ArrayList<Action> actionsPerLocation(ArrayList<Action> actions, String location) {
        ArrayList<Action> filteredActions = new ArrayList<>();

        for (Action action : actions) {
            if (action.getLocation().equals(location)) {
                filteredActions.add(action);
            }
        }

        return filteredActions;
    }

    public static ArrayList<Action> sortActionsByStat(ArrayList<Action> actions, String stat) {
        ArrayList<Action> filteredActions = new ArrayList<>();

        for (Action action : actions) {
            if (action.getTypeOfStat().equals(stat)) {
                filteredActions.add(action);
            }
        }

        return filteredActions;
    }

    public static String actionsAvailableAsString(ArrayList<Action> actions) {
        String allActions = "";

        if (actions.isEmpty()) {
            return "nothing";
        }

        for (int i = 0; i < actions.size(); i++) {
            allActions += actions.get(i).getName();
            if (i != actions.size() - 1) {
                allActions += ", ";
            }
        }

        return allActions;
    }

    public static void increaseEnergy(int statIncreaseAmount) {
        double newEnergy = Sim.getEnergy() + statIncreaseAmount;

        if (newEnergy > MAX_PER_STAT) {
            Sim.setEnergy(MAX_PER_STAT);
        } else {
            Sim.setEnergy(newEnergy);
        }

    }

    public static void increaseHunger(int statIncreaseAmount) {
        double newHunger = Sim.getHunger() + statIncreaseAmount;

        if (newHunger > MAX_PER_STAT) {
            Sim.setHunger(MAX_PER_STAT);
        } else {
            Sim.setHunger(newHunger);
        }

    }

    public static void increaseFun(int statIncreaseAmount) {
        double newFun = Sim.getFun() + statIncreaseAmount;

        if (newFun > MAX_PER_STAT) {
            Sim.setFun(MAX_PER_STAT);
        } else {
            Sim.setFun(newFun);
        }

    }

    public static void increaseSocial(int statIncreaseAmount) {
        double newSocial = Sim.getHunger() + statIncreaseAmount;

        if (newSocial > MAX_PER_STAT) {
            Sim.setSocial(MAX_PER_STAT);
        } else {
            Sim.setSocial(newSocial);
        }

    }

    public static void increaseHygiene(int statIncreaseAmount) {
        double newHygiene = Sim.getHygiene() + statIncreaseAmount;

        if (newHygiene > MAX_PER_STAT) {
            Sim.setHygiene(MAX_PER_STAT);
        } else {
            Sim.setHygiene(newHygiene);
        }
    }

    public static void increaseBladder(int statIncreaseAmount) {
        double newBladder = Sim.getBladder() + statIncreaseAmount;

        if (newBladder > MAX_PER_STAT) {
            Sim.setBladder(MAX_PER_STAT);
        } else {
            Sim.setBladder(newBladder);
        }

    }

/*
    public static void increaseStats(String statToIncrease, int statIncreaseAmount) {
        switch (statToIncrease) {
            case "energy":
                int newEnergy = Sim.getEnergy() + statIncreaseAmount;

                if (newEnergy > MAX_PER_STAT) {
                    Sim.setEnergy(MAX_PER_STAT);
                } else {
                    Sim.setEnergy(newEnergy);
                }

                break;

            case "hunger":
                int newHunger = Sim.getHunger() + statIncreaseAmount;

                if (newHunger > MAX_PER_STAT) {
                    Sim.setHunger(MAX_PER_STAT);
                } else {
                    Sim.setHunger(newHunger);
                }

                break;

            case "fun":
                int newFun = Sim.getFun() + statIncreaseAmount;

                if (newFun > MAX_PER_STAT) {
                    Sim.setFun(MAX_PER_STAT);
                } else {
                    Sim.setFun(newFun);
                }

                break;

            case "social":
                int newSocial = Sim.getHunger() + statIncreaseAmount;

                if (newSocial > MAX_PER_STAT) {
                    Sim.setSocial(MAX_PER_STAT);
                } else {
                    Sim.setSocial(newSocial);
                }

                break;

            case "hygiene":
                int newHygiene = Sim.getHygiene() + statIncreaseAmount;

                if (newHygiene > MAX_PER_STAT) {
                    Sim.setHygiene(MAX_PER_STAT);
                } else {
                    Sim.setHygiene(newHygiene);
                }

                break;

            case "bladder":
                int newBladder = Sim.getBladder() + statIncreaseAmount;

                if (newBladder > MAX_PER_STAT) {
                    Sim.setHunger(MAX_PER_STAT);
                } else {
                    Sim.setHunger(newBladder);
                }

                break;
        }
    }*/


}
