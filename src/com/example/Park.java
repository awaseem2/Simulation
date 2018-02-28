package com.example;

public class Park extends Location {

    private String name = "park";

    @Override
    String getName() {
        return name;
    }

    @Override
    /** Moves time forward and allows the sim to lose and increase stats randomly. */
    void nextEpoch() {
        NextEpochManager.handleNextEpoch();
    }

    @Override
    /** Moves the Sim to the desired location. */
    void moveTo(String locationName) {
        locationName = locationName.toLowerCase();
        if (locationName.equals("work")) {
            Location location = UtilityFunctions.getLocationsMap().get(locationName);
            Sim.setCurrentLocation(location);
            ActionManager.initializeFilteredActionsLists(location);

        } else if (locationName.equals("home")) {
            Location location = UtilityFunctions.getLocationsMap().get(locationName);
            Sim.setCurrentLocation(location);
            ActionManager.initializeFilteredActionsLists(location);
        } else {
            System.out.println("Invalid location.");
        }
    }
}
