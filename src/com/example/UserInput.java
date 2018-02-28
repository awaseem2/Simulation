package com.example;

import java.util.List;

public class UserInput {

    public static void handleUserInput(String input) {
        int indexOfAction;
        int statIncrease;
        List<Action> currentLocationActions = ActionManager.getCurrentLocationActions();

        for (Action action : ActionManager.getEnergyActions()) {
            if (action.getName().equals(input)) {
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                UtilityFunctions.increaseEnergy(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());
                Time.fixUpdatedTime();
                System.out.println("Energy is now " + Sim.getEnergy());
                return;
            }
        }


        for (Action action : ActionManager.getHungerActions()) {
            if (action.getName().equals(input)) {
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                UtilityFunctions.increaseHunger(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());
                Time.fixUpdatedTime();
                System.out.println("Hunger is now " + Sim.getHunger());
                return;
            }
        }

        for (Action action : ActionManager.getFunActions()) {
            if (action.getName().equals(input)) {
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                UtilityFunctions.increaseFun(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());
                Time.fixUpdatedTime();
                System.out.println("Fun is now " + Sim.getFun());
                return;
            }
        }

        for (Action action : ActionManager.getSocialActions()) {
            if (action.getName().equals(input)) {
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                UtilityFunctions.increaseSocial(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());
                Time.fixUpdatedTime();
                System.out.println("Social is now " + Sim.getSocial());
                return;
            }
        }

        for (Action action : ActionManager.getHygieneActions()) {
            if (action.getName().equals(input)) {
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                UtilityFunctions.increaseHygiene(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());
                Time.fixUpdatedTime();
                System.out.println("Hygiene is now " + Sim.getHygiene());
                return;
            }
        }

        for (Action action : ActionManager.getBladderActions()) {
            if (action.getName().equals(input)) {
                indexOfAction = currentLocationActions.indexOf(action);
                statIncrease = currentLocationActions.get(indexOfAction).getStatIncreaseAmount();
                UtilityFunctions.increaseBladder(statIncrease);
                Time.setMinute(Time.getMinute() +
                        currentLocationActions.get(indexOfAction).getTimeIncreaseAmount());
                Time.fixUpdatedTime();
                System.out.println("Bladder is now " + Sim.getBladder());
                return;
            }
        }

        if (input.equals("next epoch")) {
            Sim.getCurrentLocation().nextEpoch();
        } else if (input.equals("current time")) {
            System.out.println("It is currently " + Time.getCurrentTime());
        } else {
            System.out.println("Invalid input.");
        }
    }

}
