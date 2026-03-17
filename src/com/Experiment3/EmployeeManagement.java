package com.Experiment3;
//Parent Class
class Employee {
 int empId;
 String name;
 double salary;

 // Constructor
 Employee(int id, String n, double s) {
     empId = id;
     name = n;
     salary = s;
 }

 // Method to display employee details
 void display() {
     System.out.println("Employee ID: " + empId);
     System.out.println("Employee Name: " + name);
     System.out.println("Salary: " + salary);
 }

 // Method Overloading
 void calculateBonus() {
     System.out.println("Default Bonus: 2000");
 }

 void calculateBonus(double percentage) {
     double bonus = salary * percentage / 100;
     System.out.println("Bonus based on percentage: " + bonus);
 }
}


//Child Class (Inheritance)
class Manager extends Employee {

 String department;

 Manager(int id, String n, double s, String dept) {
     super(id, n, s);   // calling parent constructor
     department = dept;
 }

 // Method Overriding
 @Override
 void display() {
     super.display();
     System.out.println("Department: " + department);
 }
}


//Main Class
public class EmployeeManagement {
 public static void main(String[] args) {

     // Employee object
     Employee e1 = new Employee(101, "Rahul", 30000);
     System.out.println("Employee Details:");
     e1.display();

     System.out.println();
     e1.calculateBonus();          // Overloaded method
     e1.calculateBonus(10);        // Overloaded method

     System.out.println("\nManager Details:");

     // Manager object
     Manager m1 = new Manager(201, "Priya", 50000, "IT");
     m1.display();                 // Overridden method
 }
}