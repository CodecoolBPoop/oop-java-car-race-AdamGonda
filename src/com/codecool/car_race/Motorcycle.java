package com.codecool.car_race;

import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;

public class Motorcycle extends Vehicle{

    public static int motorcycleNumber;

    public Motorcycle(){
        name = Integer.toString(motorcycleNumber);
        motorcycleNumber++;
    }

    @Override
    public void moveForAnHour(Race race) {
        prepareForLap(race);
        distanceTraveled += speed;
    }

    @Override
    public void prepareForLap(Race race) {
        int normalSpeed = 100;
        boolean isRaining = race.isRaining();

        if(isRaining){
            int rainPenalty = ThreadLocalRandom.current().nextInt(5, 50 + 1);
            speed = (normalSpeed - rainPenalty);
        }else{
            speed = normalSpeed;
        }
    }
}
