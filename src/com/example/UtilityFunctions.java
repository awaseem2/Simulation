package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class UtilityFunctions {
    private static HashMap<String, Location> locationsMap = new HashMap<>();

    public static HashMap<String, Location> getLocationsMap() {
        return locationsMap;
    }

    /** Initializes the hashmap
     *
     * @param home the Home object
     * @param work the Work object.
     * @param park the Park object.
     */
    public static void initializeLocations(Home home, Work work, Park park) {
        locationsMap.put("home", home);
        locationsMap.put("work", work);
        locationsMap.put("park", park);
    }

    /** Filters actions by location
     *
     * @param actions all the actions available.
     * @param location the location that the player wants to filter by.
     * @return an ArrayList of Action of the actions at that location.
     */
    public static List<Action> actionsPerLocation(List<Action> actions, String location) {
        List<Action> filteredActions = new ArrayList<>();

        for (Action action : actions) {
            if (action.getLocation().equals(location)) {
                filteredActions.add(action);
            }
        }

        return filteredActions;
    }

    public static List<Action> sortActionsByStat(List<Action> actions, String stat) {
        List<Action> filteredActions = new ArrayList<>();

        for (Action action : actions) {
            if (action.getTypeOfStat().equals(stat)) {
                filteredActions.add(action);
            }
        }

        return filteredActions;
    }

    /** Concatenates all the actions into a string separated by commas
     *
     * @param actions the actions that need to be concatenated
     * @return a String of all the action names together.
     */
    public static String actionsAvailableAsString(List<Action> actions) {
        String allActions = "";

        if (actions.isEmpty()) {
            return "nothing";
        }

        for (int i = 0; i < actions.size(); i++) {
            allActions += actions.get(i).getName();
            if (i != actions.size() - 1) {
                allActions += ", ";
            }
        }

        return allActions;
    }

}
