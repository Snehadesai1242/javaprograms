package com.Experiment6;

import java.util.Scanner;

public class MultiplicationAndSquare{

    // Method to print multiplication table
    public static void printTable(int num) {
        System.out.println("\n--- Multiplication Table of " + num + " ---");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    // Method to calculate square
    public static int calculateSquare(int num) {
        return num * num;
    }

    // Method to calculate cube
    public static int calculateCube(int num) {
        return num * num * num;
    }

    // Method to check if number is positive or negative
    public static void checkNumberType(int num) {
        if (num > 0) {
            System.out.println("The number is Positive.");
        } else if (num < 0) {
            System.out.println("The number is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        System.out.println("======================================");
        System.out.println("  MULTIPLICATION TABLE & SQUARE APP  ");
        System.out.println("======================================");

        do {
            int number;

            // Input validation
            while (true) {
                System.out.print("\nEnter a number: ");
                if (sc.hasNextInt()) {
                    number = sc.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    sc.next(); // clear invalid input
                }
            }

            // Display number type
            checkNumberType(number);

            // Print multiplication table
            printTable(number);

            // Calculate square and cube
            int square = calculateSquare(number);
            int cube = calculateCube(number);

            System.out.println("\nSquare of " + number + " = " + square);
            System.out.println("Cube of " + number + " = " + cube);

            // Additional feature: sum of table
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += (number * i);
            }
            System.out.println("Sum of multiplication table = " + sum);

            // Ask user to continue
            System.out.print("\nDo you want to continue? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println("\nThank you for using the program!");
        sc.close();
    }
}