package com.example;
import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Home extends Location {
    private String name = "home";
    private boolean playerAtLocation = false;

    private ArrayList<Action> homeActions = UtilityFunctions.actionsPerLocation(
            Sim.getAvailableActions(), name);
    private ArrayList<Action> energyActions = UtilityFunctions.sortActionsByStat(
            homeActions, "energy");
    private ArrayList<Action> hungerActions = UtilityFunctions.sortActionsByStat(
            homeActions, "hunger");
    private ArrayList<Action> funActions = UtilityFunctions.sortActionsByStat(
            homeActions, "fun");
    private ArrayList<Action> socialActions = UtilityFunctions.sortActionsByStat(
            homeActions, "social");
    private ArrayList<Action> hygieneActions = UtilityFunctions.sortActionsByStat(
            homeActions, "hygiene");
    private ArrayList<Action> bladderActions = UtilityFunctions.sortActionsByStat(
            homeActions, "bladder");

    private final int EPOCH_TIME_ADVANCE = 12;


    public String getName() {
        return name;
    }

    public boolean isPlayerAtLocation() {
        return playerAtLocation;
    }

    public void setPlayerAtLocation(boolean playerAtLocation) {
        this.playerAtLocation = playerAtLocation;
    }

    @Override
    public void handleUserInput(String input) {
        input = input.toLowerCase();
        /*switch (input) {

            case "next epoch":
                nextEpoch();
                break;

            case "current time":
                System.out.println("It is day " + Time.getDay() + ", hour " + Time.getHour()
                        + ", and minute " + Time.getMinute());
                break;

            default:
                System.out.println("That is not a valid action.");
        }*/
        int indexOfAction = homeActions.indexOf(input);

        if (energyActions.contains(input)) {
            UtilityFunctions.increaseEnergy(homeActions.get(indexOfAction)
                    .getStatIncreaseAmount());
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();

        } else if (hungerActions.contains(input)) {
            UtilityFunctions.increaseHunger(homeActions.get(indexOfAction)
                    .getStatIncreaseAmount());
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();

        } else if (funActions.contains(input)) {
            UtilityFunctions.increaseFun(homeActions.get(indexOfAction)
                    .getStatIncreaseAmount());
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();

        } else if (socialActions.contains(input)) {
            UtilityFunctions.increaseSocial(homeActions.get(indexOfAction)
                    .getStatIncreaseAmount());
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();

        } else if (hygieneActions.contains(input)) {
            UtilityFunctions.increaseHygiene(homeActions.get(indexOfAction)
                    .getStatIncreaseAmount());
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();

        } else if (bladderActions.contains(input)) {
            UtilityFunctions.increaseBladder(homeActions.get(indexOfAction)
                    .getStatIncreaseAmount());
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();

        }



    }


    @Override
    public void nextEpoch() {



    }

    @Override
    void moveTo() {

    }
}
