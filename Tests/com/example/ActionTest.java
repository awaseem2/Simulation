package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {

    private Action action;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        Simsville.setSimsGame(gson.fromJson(DataManager.getFileContentsAsString(
                "Actions.json"), SimsGame.class));
        Simsville.getSimsGame().initializeSimulation();
        action = ActionManager.getCurrentLocationActions().get(0); //deep sleep
    }

    @Test
    public void getName() {
        assertEquals("deep sleep", action.getName());
    }

    @Test
    public void getLocation() {
        assertEquals("home", action.getLocation());
    }

    @Test
    public void getTypeOfStat() {
        assertEquals("bladder", action.getTypeOfStat());
    }

    @Test
    public void getStatIncreaseAmount() {
        assertEquals(9, action.getStatIncreaseAmount());
    }

    @Test
    public void getTimeIncreaseAmount() {
        assertEquals(10, action.getTimeIncreaseAmount());
    }

}