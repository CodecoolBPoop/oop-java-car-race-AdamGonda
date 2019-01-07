package com.codecool.car_race;


public class Main {

    /**
     * Creates all the vehicles that will be part of this race.
     */
    private static void createVehicles(Race race) {
        Vehicle[] vehicles = new Vehicle[30];
        for (int i = 0; i < vehicles.length; i++) {
            if(i < 10){
                vehicles[i] = new Car();
            }else if(i >= 10 && i < 20){
                vehicles[i] = new Truck();
            }else{
                vehicles[i] = new Motorcycle();
            }
        }

        race.setVehicles(vehicles);
    }

    /**
     * Entry point of our program. Creates one race instance and
     * uses that.
     * <p>
     *
     * @param args commandline arguments passed to the program.
     *             It is unused.
     */
    public static void main(String[] args) {
        Race race = new Race();
        createVehicles(race);

        race.simulateRace();
        race.printRaceResults();
    }
}
