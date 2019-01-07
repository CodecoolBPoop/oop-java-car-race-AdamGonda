package com.codecool.car_race;

public abstract class Vehicle {
    protected int distanceTraveled;
    protected int speed;
    protected String name;

    public abstract void moveForAnHour(Race race);
    public abstract void prepareForLap(Race race);

    public void printRaceData() {
        System.out.println(name + ": " +" Distance Traveled: " + distanceTraveled);
    }

}
