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
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getMake() {
        return make;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public ArrayList<Vehicle> getVehicleByPrice(double min, double max) {
        return null;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {
        return null;
    }

    public ArrayList<Vehicle> getVehicleByYear(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehicleByColor(String color) {
        return null;
    }

    public ArrayList<Vehicle> getVehicleByMileage(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehicleByType(String type) {
        return null;
    }

    public void removeVehicle(Vehicle vehicle) {

    }

}
