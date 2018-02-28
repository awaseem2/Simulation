package com.example;
import java.util.ArrayList;
import java.util.Scanner;

public class SimsGame {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Action> actions;
    boolean isFirstEpoch;
    private Home home;
    private Work work;
    private Park park;

    public void initializeSimulation() {
        home = new Home();
        work = new Work();
        park = new Park();
        UtilityFunctions.initializeLocations(home, work, park);
        /*UtilityFunctions.setCurrentLocation(home.getName());
        home.setPlayerAtLocation(true);*/
        Sim.setAvailableActions(actions);
        Sim.setCurrentLocation(home);
        Sim.setStatsToFull();
        Sim.setAlive(true);

        isFirstEpoch = true;
        handleUserInput();

    }

    public void runSimulation() {
        while (Sim.isAlive()) {
            handleUserInput();
        }

    }

    public void handleUserInput() {
        if (isFirstEpoch) {
            System.out.println("You have entered a game of SimsGame.");
            System.out.println("Much like normal sims, you have a number of things to do at your " +
                    "current location to increase your sim's stats of 'energy', 'hunger', " +
                    "'social', 'fun', 'hygiene', and 'bladder'.");
            System.out.println("You will give your sim actions to do before an epoch is run. " +
                    "When you say 'next epoch', time is advanced by 12 hours and your sim runs " +
                    "on autopilot.");
            isFirstEpoch = false;
        }

        Location currentLocation = Sim.getCurrentLocation();
        String currentLocationName = currentLocation.getName();
        System.out.println("Your sim is currently at " + currentLocationName);
        System.out.println("The actions available in this room are "
                + UtilityFunctions.actionsAvailableAsString(UtilityFunctions.actionsPerLocation(
                Sim.getAvailableActions(), currentLocationName)));

        String userInput = "";

        while (!userInput.equals("next epoch")) {
            System.out.println("Input what you would like your sim to do. " +
                    "When you are done, say 'next epoch'.");
            userInput = scanner.nextLine();
            currentLocation.handleUserInput(userInput);
        }

        System.out.println("Your sim has died! Thanks for playing The Sims.");


    }


}
