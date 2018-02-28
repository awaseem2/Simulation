package com.example;

import java.util.List;
import java.util.Random;

public class NextEpochManager {
    private static final double MINIMUM_DECREASE_FACTOR = .45;
    private static final double MAXIMUM_DECREASE_FACTOR = .75;
    private static final int EPOCH_LENGTH = 12;

    /** Decreases two random stats, increases the lowest stat, and updates time. */
    public static void handleNextEpoch() {
        ActionManager.initializeFilteredActionsLists(Sim.getCurrentLocation());
        int timePassed = 0;
        while (timePassed < (EPOCH_LENGTH * Time.getMinuteConstant())) {
            NextEpochManager.decreaseRandomStat();
            NextEpochManager.decreaseRandomStat();
            if (!Sim.isAlive()) {
                System.out.println("Your sim has died on " + Time.getCurrentTime()
                        + ". Thanks for playing!");
                System.exit(0);
            }
            timePassed += NextEpochManager.increaseLowestStat();
            Sim.printStats();
        }

        Time.setMinute(timePassed);
        Time.fixUpdatedTime();
    }

    /** Generates a random int 1-6 and decreases that respective stat.
     *
     * Used: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
     */
    public static void decreaseRandomStat() {
        final int NUMBER_OF_STATS = 6;
        final int MINIMUM = 1;
        Random random = new Random();
        int randomInteger = random.nextInt((NUMBER_OF_STATS - MINIMUM) + 1) + MINIMUM;
        int newValue;

        switch (randomInteger) {
            case 1:
                newValue = (int) (Sim.getEnergy() *
                        randomDouble(MINIMUM_DECREASE_FACTOR, MAXIMUM_DECREASE_FACTOR));
                Sim.setEnergy(newValue);
                System.out.println("Energy has decreased to " + newValue);
                break;

            case 2:
                newValue = (int) (Sim.getHunger() *
                        randomDouble(MINIMUM_DECREASE_FACTOR, MAXIMUM_DECREASE_FACTOR));
                Sim.setHunger(newValue);
                System.out.println("Hunger has decreased to " + newValue);
                break;

            case 3:
                newValue = (int) (Sim.getFun() * randomDouble(
                        MINIMUM_DECREASE_FACTOR, MAXIMUM_DECREASE_FACTOR));
                Sim.setFun(newValue);
                System.out.println("Fun has decreased to " + newValue);
                break;

            case 4:
                newValue = (int) (Sim.getSocial() * randomDouble(
                        MINIMUM_DECREASE_FACTOR, MAXIMUM_DECREASE_FACTOR));
                Sim.setSocial(newValue);
                System.out.println("Social has decreased to " + newValue);
                break;

            case 5:
                newValue = (int) (Sim.getHygiene() * randomDouble(
                        MINIMUM_DECREASE_FACTOR, MAXIMUM_DECREASE_FACTOR));
                Sim.setHygiene(newValue);
                System.out.println("Hygiene has decreased to " + newValue);
                break;

            case 6:
                newValue = (int) (Sim.getBladder() * randomDouble(
                        MINIMUM_DECREASE_FACTOR, MAXIMUM_DECREASE_FACTOR));
                Sim.setBladder(newValue);
                System.out.println("Bladder has decreased to " + newValue);
                break;
        }
    }


    /** Generates a random double within a given range
     * Used: https://stackoverflow.com/questions/3680637/generate-a-random-double-in-a-range
     *
     * @param minimum the min value of the range
     * @param maximum the max value of the range
     * @return a random double in that range.
     */
    public static double randomDouble(double minimum, double maximum) {
        Random random = new Random();
        double randomValue = minimum + (maximum - minimum) * random.nextDouble();
        return randomValue;
    }

    public static String findLowestStat() {
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

    /** Increases the lowest stat by a random action of that corresponding stat.
     *
     * @return the amount of time taken performing the random action.
     */
    public static int increaseLowestStat() {
        String lowestStat = findLowestStat();
        Random random = new Random();
        int randomIndex;
        int additionalTime = 0;

        switch (lowestStat) {
            case "energy":
                randomIndex = random.nextInt((ActionManager.getEnergyActions().size()));
                if (ActionManager.getEnergyActions().size() > 0) {
                    int additionalEnergy = ActionManager.getEnergyActions()
                            .get(randomIndex).getStatIncreaseAmount();
                    StatsManager.increaseEnergy(additionalEnergy);

                    additionalTime = ActionManager.getEnergyActions()
                            .get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();

                    System.out.println("Energy has increased by " + additionalEnergy);
                }

                break;

            case "hunger":
                randomIndex = random.nextInt((ActionManager.getHungerActions().size()));
                if (ActionManager.getHungerActions().size() > 0) {
                    int additionalHunger = ActionManager.getHungerActions()
                            .get(randomIndex).getStatIncreaseAmount();
                    StatsManager.increaseHunger(additionalHunger);

                    additionalTime = ActionManager.getHungerActions()
                            .get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();

                    System.out.println("Hunger has increased by " + additionalHunger);
                }
                break;

            case "fun":
                randomIndex = random.nextInt((ActionManager.getFunActions().size()));
                if (ActionManager.getFunActions().size() > 0) {
                    int additionalFun = ActionManager.getFunActions()
                            .get(randomIndex).getStatIncreaseAmount();
                    StatsManager.increaseFun(additionalFun);

                    additionalTime = ActionManager.getFunActions()
                            .get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();

                    System.out.println("Fun has increased by " + additionalFun);
                }
                break;

            case "social":
                randomIndex = random.nextInt((ActionManager.getSocialActions().size()));
                if (ActionManager.getSocialActions().size() > 0) {
                    int additionalSocial = ActionManager.getSocialActions()
                            .get(randomIndex).getStatIncreaseAmount();
                    StatsManager.increaseSocial(additionalSocial);

                    additionalTime = ActionManager.getSocialActions()
                            .get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();

                    System.out.println("Social has increased by " + additionalSocial);
                }
                break;

            case "hygiene":
                randomIndex = random.nextInt((ActionManager.getHygieneActions().size()));
                if (ActionManager.getHygieneActions().size() > 0) {
                    int additionalHygiene = ActionManager.getHygieneActions()
                            .get(randomIndex).getStatIncreaseAmount();
                    StatsManager.increaseHygiene(additionalHygiene);

                    additionalTime = ActionManager.getHygieneActions().get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();

                    System.out.println("Hygiene has increased by " + additionalHygiene);
                }
                break;

            case "bladder":
                randomIndex = random.nextInt((ActionManager.getBladderActions().size()));
                if (ActionManager.getBladderActions().size() > 0) {
                    int additionalBladder = ActionManager.getBladderActions()
                            .get(randomIndex).getStatIncreaseAmount();
                    StatsManager.increaseBladder(additionalBladder);

                    additionalTime = ActionManager.getBladderActions()
                            .get(randomIndex).getTimeIncreaseAmount();
                    Time.setMinute(additionalTime);
                    Time.fixUpdatedTime();

                    System.out.println("Bladder has increased by " + additionalBladder);
                }
                break;

        }

        return additionalTime;
    }

}
