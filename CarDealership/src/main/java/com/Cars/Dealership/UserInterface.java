package com.Cars.Dealership;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager = new DealershipFileManager();
    Scanner scanner = new Scanner(System.in);

    public void display(){
        init();
        while (true){
            displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByTypeRequest();
                    break;
                case 7:
                    processAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Exiting goodbye");
                    break;
                default:
                    System.out.println("Invalid option please try again");

            }

        }
    }
    private void init(){
        this.dealership = fileManager.getDealership(dealership);
    }

    private void displayMenu(){
        System.out.println("\nWelcome to " + dealership.getName());
        System.out.println("1 - Find vehicles by price");
        System.out.println("2 - Find vehicles by make and model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("Select an option: ");
    }

    private void displayVehicles(ArrayList<Vehicle>vehicles){
        if (vehicles == null || vehicles.isEmpty()){
            System.out.println("Vehicle not found");
            return;
        }
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }
    private void processAllVehiclesRequest(){
        displayVehicles(dealership.getInventory());
    }

    private void processGetByPriceRequest(){
        System.out.println("Min price:");
        double min = scanner.nextDouble();
        System.out.println("Max price");
        double max = scanner.nextDouble();
        displayVehicles(dealership.getVehicleByPrice(min, max));
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        displayVehicles(dealership.getVehicleByMakeModel(make, model));
    }

    private void processGetByYearRequest() {
        System.out.print("Min year: ");
        int min = scanner.nextInt();
        System.out.print("Max year: ");
        int max = scanner.nextInt();
        displayVehicles(dealership.getVehicleByYear(min, max));
    }

    private void processGetByColorRequest() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        displayVehicles(dealership.getVehicleByColor(color));
    }

    private void processGetByMileageRequest() {
        System.out.print("Min mileage: ");
        int min = scanner.nextInt();
        System.out.print("Max mileage: ");
        int max = scanner.nextInt();
        displayVehicles(dealership.getVehicleByMileage(min, max));
    }
    private void processGetByTypeRequest(){
        System.out.println("Type(Car/Truck/SUV/Van)");
        String type = scanner.nextLine();
        displayVehicles(dealership.getVehicleByType(type));
    }

    private void processAddVehicleRequest(){
        System.out.print("VIN: ");
        int vin = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        fileManager.getDealership(dealership);
        System.out.println("Vehicle added successfully.");
    }

    private void processRemoveVehicleRequest(){
        System.out.println("Enter VIN of the vehicle you want to remove");
        int vin = scanner.nextInt();
        Vehicle toRemove = null;
        for (Vehicle vehicle : dealership.getInventory()){
            if (vehicle.getVin() == vin){
                toRemove = vehicle;
                break;
            }
        }
        if (toRemove != null){
            dealership.removeVehicle(toRemove);
            fileManager.getDealership(dealership);
            System.out.println("Vehicle removed.");
        }else {
            System.out.println("Vehicle not found");
        }
    }
}
