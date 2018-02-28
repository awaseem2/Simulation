package com.example;

public class Action {
    private String name;
    private String location;
    private String typeOfStat;
    private int statIncreaseAmount;
    private int timeIncreaseAmount;
    private int simoleanIncreaseAmount;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTypeOfStat() {
        return typeOfStat;
    }

    public int getStatIncreaseAmount() {
        return statIncreaseAmount;
    }

    public int getTimeIncreaseAmount() {
        return timeIncreaseAmount;
    }

    public int getSimoleanIncreaseAmount() {
        return simoleanIncreaseAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTypeOfStat(String typeOfStat) {
        this.typeOfStat = typeOfStat;
    }

    public void setStatIncreaseAmount(int statIncreaseAmount) {
        this.statIncreaseAmount = statIncreaseAmount;
    }

    public void setTimeIncreaseAmount(int timeIncreaseAmount) {
        this.timeIncreaseAmount = timeIncreaseAmount;
    }

    public void setSimoleanIncreaseAmount(int simoleanIncreaseAmount) {
        this.simoleanIncreaseAmount = simoleanIncreaseAmount;
    }
}
