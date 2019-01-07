package com.codecool.car_race;


import java.util.concurrent.ThreadLocalRandom;

public class Truck extends Vehicle {

    private int breakdownTurnsLeft = 0;

    public Truck(){
        name = Integer.toString(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
    }

    @Override
    public void moveForAnHour(Race race) {
        prepareForLap(race);
        distanceTraveled += speed;
    }

    @Override
    public void prepareForLap(Race race) {
        // speed: 100km/h. 5% chance of breaking down for 2 turns.
        speed = 100;

        if(breakdownTurnsLeft == 0){
            double breakDownChance = Math.random();
            if(breakDownChance > 0.95){
                breakdownTurnsLeft = 2;
            }
        }else{
            speed = 0;
            breakdownTurnsLeft--;
        }
    }

    public int getBreakdownTurnsLeft(){
        return breakdownTurnsLeft;
    }
}
