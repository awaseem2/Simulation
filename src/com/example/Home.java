package com.example;
import java.util.*;

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
        int statIncrease;

        if (energyActions.contains(input)) {
            statIncrease = homeActions.get(indexOfAction).getStatIncreaseAmount();
            UtilityFunctions.increaseEnergy(statIncrease);
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();
            System.out.println("Energy is now " + Sim.getEnergy());

        } else if (hungerActions.contains(input)) {
            statIncrease = homeActions.get(indexOfAction).getStatIncreaseAmount();
            UtilityFunctions.increaseHunger(statIncrease);
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();
            System.out.println("Hunger is now " + Sim.getHunger());

        } else if (funActions.contains(input)) {
            statIncrease = homeActions.get(indexOfAction).getStatIncreaseAmount();
            UtilityFunctions.increaseFun(statIncrease);
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();
            System.out.println("Fun is now " + Sim.getFun());

        } else if (socialActions.contains(input)) {
            statIncrease = homeActions.get(indexOfAction).getStatIncreaseAmount();
            UtilityFunctions.increaseSocial(statIncrease);
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();
            System.out.println("Social is now " + Sim.getSocial());

        } else if (hygieneActions.contains(input)) {
            statIncrease = homeActions.get(indexOfAction).getStatIncreaseAmount();
            UtilityFunctions.increaseHygiene(statIncrease);
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();
            System.out.println("Hygiene is now " + Sim.getHygiene());

        } else if (bladderActions.contains(input)) {
            statIncrease = homeActions.get(indexOfAction).getStatIncreaseAmount();
            UtilityFunctions.increaseBladder(statIncrease);
            Time.setMinute(Time.getMinute() +
                    homeActions.get(indexOfAction).getTimeIncreaseAmount());
            Time.fixUpdatedTime();
            System.out.println("Bladder is now " + Sim.getBladder());

        } else if (input.equals("next epoch")) {
            nextEpoch();

        } else if (input.equals("current time")) {
            System.out.println("It is day " + Time.getDay() + ", hour " + Time.getHour()
                    + ", and minute " + Time.getMinute());
        } else {
            System.out.println("Invalid input.");

        }
    }


    @Override
    public void nextEpoch() {
        int timePassed = 0;
        while (timePassed < (12 * 60)) {
            decreaseRandomStat();
            decreaseRandomStat();
            timePassed += increaseLowestStat(findLowestStat());
            timePassed += increaseLowestStat(findLowestStat());
            timePassed += increaseLowestStat(findLowestStat());
        }

        Time.setMinute(timePassed);
        Time.fixUpdatedTime();

    }

    //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
    public void decreaseRandomStat() {
        Random random = new Random();
        int randomInteger = random.nextInt((6 - 1) + 1) + 1;
        double newValue;

        switch (randomInteger) {
            case 1:
                newValue = Sim.getEnergy() * randomDouble(.5, 95);
                Sim.setEnergy(newValue);
                System.out.println("Energy has decreased by " + newValue);
                break;

            case 2:
                newValue = Sim.getHunger() * randomDouble(.5, .95);
                Sim.setHunger(newValue);
                System.out.println("Hunger has decreased by " + newValue);
                break;

            case 3:
                newValue = Sim.getFun() * randomDouble(.5, .95);
                Sim.setFun(newValue);
                System.out.println("Fun has decreased by " + newValue);
                break;

            case 4:
                newValue = Sim.getSocial() * randomDouble(.5, .95);
                Sim.setSocial(newValue);
                System.out.println("Social has decreased by " + newValue);
                break;

            case 5:
                newValue = Sim.getHygiene() * randomDouble(.5, .95);
                Sim.setHygiene(newValue);
                System.out.println("Hygiene has decreased by " + newValue);
                break;

            case 6:
                newValue = Sim.getBladder() * randomDouble(.5, .95);
                Sim.setBladder(newValue);
                System.out.println("Bladder has decreased by " + newValue);
                break;
        }
    }


    //https://stackoverflow.com/questions/3680637/generate-a-random-double-in-a-range
    public double randomDouble(double minimum, double maximum) {
        Random random = new Random();
        double randomValue = minimum + (maximum - minimum) * random.nextDouble();

        return randomValue;
    }

    public String findLowestStat() {
        double lowestStatValue = Sim.getEnergy();
        String lowestStat = "energy";

        if (lowestStatValue > Sim.getHunger()) {
            lowestStatValue = Sim.getHunger();
            lowestStat = "hunger";
        }

        if (lowestStatValue > Sim.getFun()) {
            lowestStatValue = Sim.getFun();
            lowestStat = "fun";
        }

        if (lowestStatValue > Sim.getSocial()) {
            lowestStatValue = Sim.getSocial();
            lowestStat = "social";
        }

        if (lowestStatValue > Sim.getHygiene()) {
            lowestStatValue = Sim.getHygiene();
            lowestStat = "hygiene";
        }

        if (lowestStatValue > Sim.getBladder()) {
            lowestStat = "bladder";
        }

        return lowestStat;

    }

    public int increaseLowestStat(String lowestStat) {
        Random random = new Random();
        int randomIndex;
        int additionalTime = 0;

        switch (lowestStat) {
            case "energy":
                randomIndex = random.nextInt((energyActions.size()) + 1);
                if (energyActions.size() > 0) {
                     
                    int additionalEnergy = energyActions.get(randomIndex).getStatIncreaseAmount();
                    additionalTime = energyActions.get(randomIndex).getTimeIncreaseAmount();
                    UtilityFunctions.increaseEnergy(additionalEnergy);
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();
                    System.out.println("Energy has increased by " + additionalEnergy);
                }

                break;

            case "hunger":
                randomIndex = random.nextInt((hungerActions.size()) + 1);
                if (hungerActions.size() > 0) {
                    int additionalHunger = hungerActions.get(randomIndex).getStatIncreaseAmount();
                    additionalTime = hungerActions.get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();
                    UtilityFunctions.increaseHunger(additionalHunger);
                    System.out.println("Hunger has increased by " + additionalHunger);
                }
                break;

            case "fun":
                randomIndex = random.nextInt((funActions.size()) + 1);
                if (funActions.size() > 0) {
                    int additionalFun = funActions.get(randomIndex).getStatIncreaseAmount();
                    additionalTime = funActions.get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();
                    UtilityFunctions.increaseFun(additionalFun);
                    System.out.println("Fun has increased by " + additionalFun);
                }
                break;

            case "social":
                randomIndex = random.nextInt((socialActions.size()) + 1);
                if (socialActions.size() > 0) {
                    int additionalSocial = socialActions.get(randomIndex).getStatIncreaseAmount();
                    additionalTime = socialActions.get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();
                    UtilityFunctions.increaseSocial(additionalSocial);
                    System.out.println("Social has increased by " + additionalSocial);
                }
                break;

            case "hygiene":
                randomIndex = random.nextInt((hygieneActions.size()) + 1);
                if (hygieneActions.size() > 0) {
                    int additionalHygiene = hygieneActions.get(randomIndex).getStatIncreaseAmount();
                    additionalTime = hygieneActions.get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();
                    UtilityFunctions.increaseHygiene(additionalHygiene);
                    System.out.println("Hygiene has increased by " + additionalHygiene);
                }
                break;

            case "bladder":
                randomIndex = random.nextInt((bladderActions.size()) + 1);
                if (bladderActions.size() > 0) {
                    int additionalBladder = bladderActions.get(randomIndex).getStatIncreaseAmount();
                    additionalTime = bladderActions.get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();
                    UtilityFunctions.increaseBladder(additionalBladder);
                    System.out.println("Bladder has increased by " + additionalBladder);
                }
                break;

        }

        return additionalTime;
    }

    @Override
    void moveTo() {

    }
}
