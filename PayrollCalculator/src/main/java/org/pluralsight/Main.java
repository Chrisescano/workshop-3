package org.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileToProcess = getStringInput(scanner, "Enter the name of the employee file to process: ");
        String fileToCreate = getStringInput(scanner, "Enter the name of the payroll file to create: ");

        String fileContents = readFromFile(fileToProcess);
        String[] employeesTokens = fileContents.split("\n");
        Employee[] employees = createEmployeeObjects(employeesTokens);

        //formats format of file based on extension
        String fileHeader = "", fileTail = "", stringFormat = "";
        switch(fileToCreate.substring(fileToCreate.indexOf('.'))) {
            case ".csv":
                fileHeader = "id|name|gross pay\n";
                fileTail = "%d|%s|%.2f";
                stringFormat = "%d|%s|%.2f\n";
                break;
            case ".json":
                fileHeader = "[\n";
                fileTail = "\t{ \"id\" : %d, \"name\" : %s, \"grossPay\" : %.2f }\n]";
                stringFormat = "\t{ \"id\" : %d, \"name\" : %s, \"grossPay\" : %.2f },\n";
        }

        writeToFile(fileToCreate, fileHeader, fileTail, stringFormat, employees);
    }

    public static String readFromFile(String filePath) {
        String fileContents = "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            String fileLine = "";
            bufferedReader.readLine(); //skips first line from csv that is header
            while((fileLine = bufferedReader.readLine()) != null) {
                fileContents += fileLine + "\n";
            }
        } catch(IOException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }

        return fileContents;
    }

    public static void writeToFile(String filePath, String fileHeader, String fileTail, String stringFormat, Employee[] employees) {
        int lastIndex = employees.length - 1;

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

            bufferedWriter.write(fileHeader);
            for(int i = 0; i < employees.length - 1; i++) {
                String fileLine = String.format(stringFormat, employees[i].getEmployeeID(), employees[i].getName(), employees[i].getGrossPay());
                bufferedWriter.write(fileLine);
            }
            String fileLine = String.format(fileTail, employees[lastIndex].getEmployeeID(), employees[lastIndex].getName(), employees[lastIndex].getGrossPay());
            bufferedWriter.write(fileLine);

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }

    public static Employee[] createEmployeeObjects(String[] employeesData) {
        Employee[] employees = new Employee[employeesData.length];

        for(int i = 0; i < employeesData.length; i++) {
            String[] tokens = employeesData[i].split("\\|");
            employees[i] = new Employee(
                    tokens[1],
                    Integer.parseInt(tokens[0]),
                    Double.parseDouble(tokens[2]),
                    Double.parseDouble(tokens[3])
            );
        }
        return employees;
    }

    public static String getStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input;
    }
}
