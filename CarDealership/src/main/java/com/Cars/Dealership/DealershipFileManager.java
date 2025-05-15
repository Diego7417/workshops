package com.Cars.Dealership;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DealershipFileManager {
    public Dealership getDealership(String filePath){
        Dealership dealership = null;

        try {
            FileReader fileReader = new FileReader(filePath);
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
                    assert dealership != null;
                    dealership.addVehicle(vehicle);
                }
            }

            bufferedReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dealership;
    }
//    saving dealership
    public void saveDealership(Dealership dealership){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.csv"));
//            writes dealership info (name, address, number)
             bufferedWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
             bufferedWriter.newLine();

             for (Vehicle vehicle: dealership.getInventory()){
                 String color = "";
                 String vehicleData = vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                         vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor(color) + "|" + vehicle.getOdometer() +
                         "|" + vehicle.getPrice();
                 bufferedWriter.write(vehicleData);
                 bufferedWriter.newLine();

             }
             bufferedWriter.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
