package com.example;

import java.util.ArrayList;

public class Work extends Location {
    private String name = "work";

    @Override
    String getName() {
        return name;
    }


    @Override
    /** Moves time forward and allows the sim to lose and increase stats randomly. */
    void nextEpoch() {
        Sim.setCurrentLocation(UtilityFunctions.getLocationsMap().get("home"));
        NextEpochManager.handleNextEpoch();
        Sim.setCurrentLocation(UtilityFunctions.getLocationsMap().get("work"));
    }

    @Override
    /** Moves the Sim to the desired location. */
    public void moveTo(String locationName) {
        locationName = locationName.toLowerCase();
        if (locationName.equals("home")) {
            Location location = UtilityFunctions.getLocationsMap().get(locationName);
            Sim.setCurrentLocation(location);
            ActionManager.initializeFilteredActionsLists(location);

        } else if (locationName.equals("park")) {
            Location location = UtilityFunctions.getLocationsMap().get(locationName);
            Sim.setCurrentLocation(location);
            ActionManager.initializeFilteredActionsLists(location);

        } else {
            System.out.println("Invalid location.");
        }

    }
}
