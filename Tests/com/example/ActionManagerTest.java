package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ActionManagerTest {

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        Simsville.setSimsGame(gson.fromJson(DataManager.getFileContentsAsString(
                "Actions.json"), SimsGame.class));
        Simsville.getSimsGame().initializeSimulation();
    }

    @Test
    public void getBladderActions() {
        Action tempAction = new Action();
        tempAction.setName("use toilet");
        assertEquals(tempAction.getName(), ActionManager.getBladderActions().get(0).getName());

    }
}