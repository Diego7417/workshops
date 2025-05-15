package com.Cars;

import com.Cars.Dealership.Dealership;
import com.Cars.Dealership.DealershipFileManager;
import com.Cars.Dealership.UserInterface;
import com.Cars.Dealership.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.display();
   }
}
