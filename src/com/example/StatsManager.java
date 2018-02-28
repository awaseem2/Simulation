package com.example;

public class StatsManager {

    private static final int MAX_PER_STAT = 10;

    /** Increases the Sim's energy by the amount sent in.
     *
     * @param statIncreaseAmount the amount the desired stat is to be updated by.
     */
    public static void increaseEnergy(int statIncreaseAmount) {
        double newEnergy = Sim.getEnergy() + statIncreaseAmount;

        if (newEnergy > MAX_PER_STAT) {
            Sim.setEnergy(MAX_PER_STAT);
        } else {
            Sim.setEnergy(newEnergy);
        }

    }

    /** Increases the Sim's hunger by the amount sent in.
     *
     * @param statIncreaseAmount the amount the desired stat is to be updated by.
     */
    public static void increaseHunger(int statIncreaseAmount) {
        double newHunger = Sim.getHunger() + statIncreaseAmount;

        if (newHunger > MAX_PER_STAT) {
            Sim.setHunger(MAX_PER_STAT);
        } else {
            Sim.setHunger(newHunger);
        }

    }

    /** Increases the Sim's fun by the amount sent in.
     *
     * @param statIncreaseAmount the amount the desired stat is to be updated by.
     */
    public static void increaseFun(int statIncreaseAmount) {
        double newFun = Sim.getFun() + statIncreaseAmount;

        if (newFun > MAX_PER_STAT) {
            Sim.setFun(MAX_PER_STAT);
        } else {
            Sim.setFun(newFun);
        }

    }

    /** Increases the Sim's social by the amount sent in.
     *
     * @param statIncreaseAmount the amount the desired stat is to be updated by.
     */
    public static void increaseSocial(int statIncreaseAmount) {
        double newSocial = Sim.getHunger() + statIncreaseAmount;

        if (newSocial > MAX_PER_STAT) {
            Sim.setSocial(MAX_PER_STAT);
        } else {
            Sim.setSocial(newSocial);
        }

    }

    /** Increases the Sim's hygiene by the amount sent in.
     *
     * @param statIncreaseAmount the amount the desired stat is to be updated by.
     */
    public static void increaseHygiene(int statIncreaseAmount) {
        double newHygiene = Sim.getHygiene() + statIncreaseAmount;

        if (newHygiene > MAX_PER_STAT) {
            Sim.setHygiene(MAX_PER_STAT);
        } else {
            Sim.setHygiene(newHygiene);
        }
    }

    /** Increases the Sim's bladder by the amount sent in.
     *
     * @param statIncreaseAmount the amount the desired stat is to be updated by.
     */
    public static void increaseBladder(int statIncreaseAmount) {
        double newBladder = Sim.getBladder() + statIncreaseAmount;

        if (newBladder > MAX_PER_STAT) {
            Sim.setBladder(MAX_PER_STAT);
        } else {
            Sim.setBladder(newBladder);
        }

    }
}
