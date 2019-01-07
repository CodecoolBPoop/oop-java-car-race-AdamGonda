package com.codecool.car_race;

public class Weather {
    private static boolean raining;

    public boolean isRaining(){
        return raining;
    }
    public void setRaining() {
        // 30% chance of rain.
        raining = (Math.random() > 0.7);
    }
}
