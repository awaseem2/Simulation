package com.example;

import java.util.ArrayList;

public class UtilityFunctions {
    public static String actionsAvailableAsString(ArrayList<String> actions) {
        String allActions = "";

        if (actions.isEmpty()) {
            return "nothing";
        }

        for (int i = 0; i < actions.size(); i++) {
            allActions += actions.get(i);
            if (i != actions.size() - 1) {
                allActions += ", ";
            }
        }

        return allActions;
    }
}
