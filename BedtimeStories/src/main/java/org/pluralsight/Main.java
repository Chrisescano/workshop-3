package org.pluralsight;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nameOfStory = getStringInput("Enter the name of a story: ");
        printFile(nameOfStory);
    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String input = scanner.next();
        scanner.nextLine();
        scanner.close();
        return input;
    }

    public static void printFile(String filePath) {
        int lineNumber = 1;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Scanner fileScanner = new Scanner(fileInputStream);
            while(fileScanner.hasNextLine()) {
                System.out.println(lineNumber + " " + fileScanner.nextLine());
                lineNumber++;
            }
            fileScanner.close();
        } catch(FileNotFoundException e) {
            System.out.println("Oops, the file does not exist, are you sure you typed in correctly?");
        }
    }
}
