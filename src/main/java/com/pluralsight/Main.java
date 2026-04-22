package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {

    public static void main(String[] args) {

        String fileName = "employees.csv";

        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] tokens = line.split("\\|");

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee emp = new Employee(id, name, hoursWorked, payRate);

                System.out.printf("ID: %d | Name: %s | Gross Pay: $%.2f%n",
                        emp.getEmployeeId(),
                        emp.getName(),
                        emp.getGrossPay());
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}