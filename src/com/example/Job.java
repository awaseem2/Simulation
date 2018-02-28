package com.example;

public class Job extends Thing {
    private final int SKILL_LEVEL_UP = 20;
    private int simoleons;
    private String name;
    private int skillLevel;

    public String getName() {
        return name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    /** Increases the sim's skill level if they have reached a new goal of time worked. */
    public void updateSkillLevel() {
        skillLevel = (Sim.getTimeWorked() * Time.getMinuteConstant()) / SKILL_LEVEL_UP;
    }

    @Override
    int getSimoleons() {
        return simoleons;
    }
}
