package com.example;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class HomeTest {

    @Before
    public void setUp() throws Exception {
        Simsville.getSimsGame().initializeSimulation();

    }

    @Test
    public void getName() {
        assertEquals("home", Sim.getCurrentLocation().getName());
    }

    @Test
    public void moveTo() {
        String input = "work";
        Sim.getCurrentLocation().moveTo(input);
        assertEquals(input, Sim.getCurrentLocation().getName());
    }
}