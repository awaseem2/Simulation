package com.example;

import java.util.List;

public class UserInput {

    /** Decides what action to take based on the user input.
     *
     * @param input what the user has input as their desired action.
     */
    public static void handleUserInput(String input) {
        int indexOfAction;
        int statIncrease;
        boolean found = false;
        ActionManager.initializeFilteredActionsLists(Sim.getCurrentLocation());
        List<Action> currentLocationActions = ActionManager.getCurrentLocationActions();

        for (Action action : ActionManager.getEnergyActions()) {
            if (action.getName().equals(input)) {
                found = true;
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                StatsManager.increaseEnergy(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());

                System.out.println("Energy is now " + Sim.getEnergy());
            }
        }


        for (Action action : ActionManager.getHungerActions()) {
            if (action.getName().equals(input)) {
                found = true;
                if (action.getSimoleanIncreaseAmount() < Sim.getBankAccount().getSimoleons()) {
                    indexOfAction = currentLocationActions.indexOf(action);
                    statIncrease = currentLocationActions
                            .get(indexOfAction).getStatIncreaseAmount();
                    StatsManager.increaseHunger(statIncrease);
                    Time.setMinute(Time.getMinute() +
                            currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());

                    Sim.getBankAccount().setSimoleons(Sim.getBankAccount().getSimoleons() +
                            action.getSimoleanIncreaseAmount());

                    System.out.println("Hunger is now " + Sim.getHunger());

                } else {
                    System.out.println("You do not have enough funds for that.");
                }

            }
        }

        for (Action action : ActionManager.getFunActions()) {
            if (action.getName().equals(input)) {
                found = true;
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                StatsManager.increaseFun(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());

                Sim.getBankAccount().setSimoleons(Sim.getBankAccount().getSimoleons() +
                        action.getSimoleanIncreaseAmount());

                if(input.split(" ")[0].equals("work")) {
                    Sim.setTimeWorked(Sim.getTimeWorked() +
                            currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());
                    Sim.getJob().updateSkillLevel();

                }

                System.out.println("Fun is now " + Sim.getFun());
            }
        }

        for (Action action : ActionManager.getSocialActions()) {
            if (action.getName().equals(input)) {
                found = true;
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                StatsManager.increaseSocial(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());

                System.out.println("Social is now " + Sim.getSocial());
            }
        }

        for (Action action : ActionManager.getHygieneActions()) {
            if (action.getName().equals(input)) {
                found = true;
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                StatsManager.increaseHygiene(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());
                Time.fixUpdatedTime();
                System.out.println("Hygiene is now " + Sim.getHygiene());
            }
        }

        for (Action action : ActionManager.getBladderActions()) {
            if (action.getName().equals(input)) {
                found = true;
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                StatsManager.increaseBladder(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());
                Time.fixUpdatedTime();
                System.out.println("Bladder is now " + Sim.getBladder());
            }
        }

        if(!found) {

            String[] inputArray = input.split(" ");

            if (inputArray.length > 2) {
                if (inputArray[0].equals("move") && inputArray[1].equals("to")) {
                    String desiredLocation = inputArray[2];
                    Sim.getCurrentLocation().moveTo(desiredLocation);

                }
            } else if (input.equals("next epoch")) {
                Sim.getCurrentLocation().nextEpoch();

            } else if (input.equals("current time")) {
                System.out.println("It is currently " + Time.getCurrentTime());

            } else if (input.equals("sim stats")) {
                Sim.printStats();
            }

            else {
                System.out.println("Invalid input.");
            }
        }
    }

}
