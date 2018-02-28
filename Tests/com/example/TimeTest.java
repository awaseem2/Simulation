package com.example;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TimeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        DataManager.getFileContentsAsString("Actions.json");
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void getDay() {
        Time.setDay(5);
        assertEquals(5, Time.getDay());
    }

    @Test
    public void getHour() {
        Time.setHour(5);
        assertEquals(5, Time.getHour());
    }

    @Test
    public void getMinute() {
        Time.setDay(5);
        assertEquals(5, Time.getMinute());
    }

    @Test
    public void fixUpdatedTime() {
        Time.setHour(23);
        Time.setMinute(65);
        assertEquals(0, Time.getHour());
    }

    @Test
    public void getCurrentTime() {
        Time.setDay(1);
        Time.setHour(10);
        Time.setMinute(45);
        assertEquals("day 1 at hour 10 minute 45\r\n", outContent.toString());
    }
}