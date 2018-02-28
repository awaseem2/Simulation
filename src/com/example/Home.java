package com.example;
import java.util.*;

public class Home extends Location {
    private String name = "home";


    public String getName() {
        return name;
    }

    @Override
    /** Moves time forward and allows the sim to lose and increase stats randomly. */
    public void nextEpoch() {
        NextEpochManager.handleNextEpoch();
    }

    @Override
    /** Moves the Sim to the desired location. */
    public void moveTo(String locationName) {
        locationName = locationName.toLowerCase();
        if (locationName.equals("work")) {
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
