package com.Cars.Dealership;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {
    public Dealership getDealership(Dealership dealership){
        Dealership dealership = null;

        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String dealershipInfo =bufferedReader.readLine();

            if(dealershipInfo != null){
                String[] parts = dealershipInfo.split("\\|");
                if(parts.length >= 3) {
                    String name = parts[0];
                    String address = parts[1];
                    String phone = parts[2];

                    dealership = new Dealership(name, address, phone);
                }
            }

            String line;

            while ((line = bufferedReader.readLine()) != null){
                String[] parts = line.split("\\|");

                if (parts.length >= 8) {
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }

            bufferedReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dealership;
    }
}
