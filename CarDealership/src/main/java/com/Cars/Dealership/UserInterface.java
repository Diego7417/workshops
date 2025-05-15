package com.Cars.Dealership;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager = new DealershipFileManager();
    static Scanner scanner = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\\u001B[32m";
    public static final String BLUE = "\\u001B[34m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BRIGHT_CYAN = "\u001B[96m";


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
                    System.out.println("Have a great day!! \uD83D\uDE01\uD83D\uDE01");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option please try again");

            }

        }
    }
    private void init(){
        this.dealership = fileManager.getDealership("inventory.csv");
    }

    private void displayMenu(){
        System.out.println(BRIGHT_CYAN + "\n===Welcome to " + dealership.getName() + RESET);
        System.out.println(  "1. Find vehicles by price");
        System.out.println("2. Find vehicles by make and model");
        System.out.println("3. Find vehicles by year range");
        System.out.println("4. Find vehicles by color");
        System.out.println("5. Find vehicles by mileage range");
        System.out.println("6. Find vehicles by type");
        System.out.println("7. List ALL vehicles");
        System.out.println("8. Add a vehicle");
        System.out.println("9. Remove a vehicle");
        System.out.println("0. Exit Application" + RESET);
        System.out.print(PURPLE + "Select an option: " + RESET);
    }

    private void displayVehicles(ArrayList<Vehicle>vehicles){
        if (vehicles == null || vehicles.isEmpty()){
            System.out.println(GREEN + "Vehicle not found" + RESET);
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
        double min = scanner.nextDouble();
        System.out.print("Max mileage: ");
        double max = scanner.nextDouble();
        displayVehicles(dealership.getVehicleByMileage(min,
                max));
    }
    private void processGetByTypeRequest(){
        System.out.println("Type(Car/Truck/SUV/Van)");
        String type = scanner.nextLine();
        displayVehicles(dealership.getVehicleByType(type));
    }

    private void processAddVehicleRequest(){
        int vin = 0;
        boolean validVin = false;
        while (!validVin) {
            System.out.print("VIN: ");
            if (scanner.hasNextInt()) {
                vin = scanner.nextInt();
                validVin = true;
            } else {
                System.out.println("Invalid VIN. Please enter a whole number.");
                scanner.next(); //
            }
            scanner.nextLine();
        }


        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();


        int odometer = 0;
        boolean validOdometer = false;
        while (!validOdometer) {
            System.out.print("Odometer: ");
            if (scanner.hasNextInt()) {
                odometer = scanner.nextInt();
                validOdometer = true;
            } else {
                System.out.println("Invalid Odometer. Please enter a whole number.");
                scanner.next();
            }
            scanner.nextLine();
        }

        double price = 0.0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("Price: ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                validPrice = true;
            } else {
                System.out.println("Invalid Price. Please enter a number.");
                scanner.next();
            }
            scanner.nextLine();
        }

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        fileManager.saveDealership(dealership);
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
            fileManager.saveDealership(dealership);
            System.out.println(GREEN + "Vehicle removed." + RESET);
        }else {
            System.out.println(BRIGHT_RED + "Vehicle not found" + RESET);
        }
    }
    private static void promptReturnToMainMenu(){
        System.out.println("\nPress Enter to Return to the Main Menu");
        scanner.nextLine();
    }
}
