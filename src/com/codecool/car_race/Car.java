package com.codecool.car_race;

import java.util.concurrent.ThreadLocalRandom;

public class Car extends Vehicle{

    private static String[] possibleNames = new String[]{"Presence","Raven","Prodigy","Presence","Tempest","Mythic","Whim","Momentum","Temperament","Centaur"};
    private int normalSpeed;
    private int[] minMaxSpeed = new int[]{80,110};


    public Car(){
        normalSpeed = ThreadLocalRandom.current().nextInt(minMaxSpeed[0], minMaxSpeed[1] + 1);
        name = pickRandomName();
        speed = normalSpeed;

    }

    private String pickRandomName(){
        String name = "";
        for (int i = 0; i < 2; i++) {
            name += possibleNames[ThreadLocalRandom.current().nextInt(0, possibleNames.length)] + " ";
        }
        return name;
    }


    public void prepareForLap(Race race) {
        // setup the actual speed used for the current lap
        if(race.isThereABrokenTruck()){
            speed = 75;
        }else{
            speed = normalSpeed;
        }
    }

    @Override
    public void moveForAnHour(Race race) {
        // If there is a broken down Truck on the track, then limit the max speed of cars to 75 km/h.
        prepareForLap(race);
        distanceTraveled += speed;
    }
}
