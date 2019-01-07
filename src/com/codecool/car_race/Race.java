package com.codecool.car_race;

public class Race {

    private Vehicle[] vehicles;
    private Weather weather = new Weather();

    public void simulateRace() {
        for (int i = 0; i < 50; i++) {
            weather.setRaining();
            for (int j = 0; j < vehicles.length; j++) {
                vehicles[j].moveForAnHour(this);
            }
            if(i % 5 == 0) printRaceStatus();
        }
    }

    private void printRaceStatus() {
        System.out.println("Is There A Broken Truck: " + isThereABrokenTruck() + "\n" +
                "is raining: " + isRaining() + "\n");
    }

    public void printRaceResults() {
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].printRaceData();
        }
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public boolean isThereABrokenTruck(){
        for (Vehicle vehicle:vehicles) {
            Truck truck = null;
            try{
                truck = (Truck) vehicle;
                if(truck.getBreakdownTurnsLeft() != 0){
                    return true;
                }
            }catch(Exception e){
                //sorry it is empty
            }
        }
        return false;
    }

    public boolean isRaining(){
        return weather.isRaining();
    }
}
