package com.Cars.Dealership;

import java.util.ArrayList;


public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    private String make;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
   public  ArrayList<Vehicle> getVehicleByPrice(double min, double max){
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max){

                result.add(vehicle);

            }
        }
        return result;
   }
   public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){
       ArrayList<Vehicle> result = new ArrayList<>();
       for(Vehicle vehicle: inventory){
           if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
               result.add(vehicle);
           }
       }
       return result;
   }
   public ArrayList<Vehicle> getVehicleByYear( double min, double max){
      ArrayList<Vehicle> result = new ArrayList<>();
       for(Vehicle vehicle: inventory){
           if (vehicle.getYear() >= min && vehicle.getYear() <= max){
               result.add(vehicle);
           }
       }
       return result;
   }
   public ArrayList<Vehicle> getVehicleByColor(String color){
        ArrayList<Vehicle> result = new ArrayList<>();
       for(Vehicle vehicle: inventory){
           if (vehicle.getColor(color).equalsIgnoreCase(color)){
               result.add(vehicle);
           }
       }
       return result;
   }


    public ArrayList<Vehicle> getVehicleByType(String vehicleType){
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                result.add(vehicle);

            }
        }
        return result;
    }
    public ArrayList<Vehicle> getAllVehicle(){
        return inventory;
    }
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> getVehicleByMileage(double min, double max) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle: inventory){
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                result.add(vehicle);
            }
        }
        return result;
    }
}


