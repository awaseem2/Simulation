package com.example;

import java.util.List;

public class ActionManager {

    private static List<Action> currentLocationActions;
    private static List<Action> energyActions;
    private static List<Action> hungerActions;
    private static List<Action> funActions;
    private static List<Action> socialActions;
    private static List<Action> hygieneActions;
    private static List<Action> bladderActions;

    /** Initializes ArrayLists for each type of stat based on the current location.
     *
     * @param currentLocation the location at which the Sim is
     */
    public static void initializeFilteredActionsLists(Location currentLocation) {
        currentLocationActions = UtilityFunctions.actionsPerLocation(
                Sim.getAvailableActions(), currentLocation.getName());

        energyActions = UtilityFunctions.sortActionsByStat(currentLocationActions, "energy");
        hungerActions = UtilityFunctions.sortActionsByStat(currentLocationActions, "hunger");
        funActions = UtilityFunctions.sortActionsByStat(currentLocationActions, "fun");
        socialActions = UtilityFunctions.sortActionsByStat(currentLocationActions, "social");
        hygieneActions = UtilityFunctions.sortActionsByStat(currentLocationActions, "hygiene");
        bladderActions = UtilityFunctions.sortActionsByStat(currentLocationActions, "bladder");
    }

    public static List<Action> getCurrentLocationActions() {
        return currentLocationActions;
    }

    public static List<Action> getEnergyActions() {
        return energyActions;
    }

    public static List<Action> getHungerActions() {
        return hungerActions;
    }

    public static List<Action> getFunActions() {
        return funActions;
    }

    public static List<Action> getSocialActions() {
        return socialActions;
    }

    public static List<Action> getHygieneActions() {
        return hygieneActions;
    }

    public static List<Action> getBladderActions() {
        return bladderActions;
    }
}
