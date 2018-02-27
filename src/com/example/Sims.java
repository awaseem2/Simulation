package com.example;

public class Sims {
    boolean isFirstEpoch;
    private Home home;
    private Work work;
    private Park park;

    public void initializeSimulation() {
        home = new Home();
        work = new Work();
        park = new Park();
        //Player.initializeLocations();
        Player.setCurrentLocation(home.getName());
        home.setPlayerAtLocation(true);
        Player.setStatsToFull();

        isFirstEpoch = true;
        handleUserInputBeforeEpoch();



    }

    public void runSimulation() {

    }

    public void handleUserInputBeforeEpoch() {
        if (isFirstEpoch) {
            System.out.println("You have entered a game of Sims.");
            System.out.println("Before each new epoch is ran, you will be able " +
                    "to control your sim.");
        }

        String currentLocationName = Player.getCurrentLocation();
        Location currentLocation = Player.getLocationsMap().get(currentLocationName);
        System.out.println("You are currently at " + currentLocationName);
        System.out.println("The actions available in this room are "
                + UtilityFunctions.actionsAvailableAsString(currentLocation.getActionsAvailable()));


    }


}
