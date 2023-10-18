package org.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //java io.FileNotFoundException
        BufferedReader bufferedReader = null;

        //try and get the file
        try {
            bufferedReader = new BufferedReader(new FileReader("employees.csv"));

            //read from the file
            String fileLine = bufferedReader.readLine(); //reads the first line of csv file
            while ((fileLine = bufferedReader.readLine()) != null) {
                String[] tokens = fileLine.split("\\|");
                Employee employee = new Employee(
                        tokens[1],
                        Integer.parseInt(tokens[0]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3])
                        );

                System.out.printf("ID: %d  Name: %-20s  GrossPay: $%.2f\n", employee.getEmployeeID(), employee.getName(), employee.getGrossPay());

            }
        } catch (FileNotFoundException e) {
            System.out.println("Oops, looks like the file does not exist!");
        } catch (IOException e) {
            System.out.println("Oops, could not read the file!");
        }
    }
}
