package com.example;

public class Time {

    private static final int MINUTE_CONSTANT = 60;
    private static final int HOUR_CONSANT = 24;
    private static int day;
    private static int hour;
    private static int minute;

    public static int getMinuteConstant() {
        return MINUTE_CONSTANT;
    }

    public static int getHourConsant() {
        return HOUR_CONSANT;
    }

    public static int getDay() {
        return day;
    }

    public static void setDay(int day) {
        Time.day = day;
    }

    public static int getHour() {
        return hour;
    }

    public static void setHour(int hour) {
        Time.hour = hour;
    }

    public static int getMinute() {
        return minute;
    }

    public static void setMinute(int minute) {
        Time.minute = minute;
    }

    public static void fixUpdatedTime() {
        if (minute >= MINUTE_CONSTANT) {
            hour += minute / MINUTE_CONSTANT;
            minute = minute % MINUTE_CONSTANT;
        }
        if (hour >= HOUR_CONSANT) {
            day += hour / HOUR_CONSANT;
            hour = hour % HOUR_CONSANT;
        }

    }

    public static String getCurrentTime() {
        return "day " + Time.getDay() + " at hour " + Time.getHour()
                + " minute " + Time.getMinute();
    }
}
