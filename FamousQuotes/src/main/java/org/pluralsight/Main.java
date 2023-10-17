package org.pluralsight;

import java.util.Scanner;

public class Main {
    static String[] famousQuotes = {
            "Excellence is not being the best. It is doing your best",
            "Life is a journey, not a destination",
            "Life isn't about finding yourself. Life is about creating yourself",
            "Don't look back. You're not going that way.",
            "Life is 10% what happens to you and 90% how you react to it.",
            "Ever tried. Ever failed. No matter. Try again. Fail again. Fail better.",
            "Quality is not an act, it is a habit.",
            "Good, better, best. Never let it rest. 'Til your good is better and your better is best.",
            "With the new day comes new strength and new thoughts.",
            "If you're going through hell, keep going."
    };
    public static void main(String[] args) {

        try {
            System.out.println("Welcome to your daily dose of inspiration!"); //welcome prompt

            while(true) {

                // prompt for random or custom quote
                int randomOrCustomQuoteStatus = randomOrCustomQuoteMenu();
                switch(randomOrCustomQuoteStatus) {
                    case 1:
                        int randomQuoteIndex = getRandomInclusive(1, 10);
                        System.out.println(famousQuotes[randomQuoteIndex] + "\n");
                        break;
                    case 0:
                        System.out.println();
                        customQuoteMenu();
                        break;
                    case -1:
                        randomOrCustomQuoteMenu();
                }

                //prompts user if they want another name
                int statusOfAnotherQuoteMenu = promptAnotherQuoteMenu();
                switch(statusOfAnotherQuoteMenu) {
                    case 1:
                        System.out.println();
                        break;
                    case 0:
                        return;
                    case -1:
                        promptAnotherQuoteMenu();
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops, looks like you entered a number not in between 1 and 10!");
        }
    }

    public static int randomOrCustomQuoteMenu() {
        char userWantsRandomQuotes = getCharInput("Would you like a random quote?\nType yes or no: ");
        switch(userWantsRandomQuotes) {
            case 'Y':
                return 1;
            case 'N':
                return 0;
            default:
                System.out.println("\nSorry, could not understand that\n");
                return -1;
        }
    }

    public static void customQuoteMenu() {
        int userNumber = geIntInput("Select a number between 1 and 10 for your quote\nType in number: ") - 1;
        System.out.println(famousQuotes[userNumber] + "\n");
    }

    public static int promptAnotherQuoteMenu() {
        char continueCommand = getCharInput("Would you like to see another quote?\nType yes or no: ");
        switch(continueCommand) {
            case 'Y':
                return 1;
            case 'N':
                System.out.println("Have a great day!");
                return 0;
            default:
                System.out.println("\nSorry, could not understand that\n");
                return -1;
        }
    }

    public static int getRandomInclusive(int min, int max) {
        return (int)((Math.random() * (max - min + 1)) + min);
    }

    public static int geIntInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        int input = Integer.parseInt(scanner.next());
        scanner.nextLine();
        return input;
    }

    public static char getCharInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        char input = scanner.next().toUpperCase().charAt(0);
        scanner.nextLine();
        return input;
    }
}
