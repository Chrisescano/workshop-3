package org.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] famousQuotes = {
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

        int userNumber = geIntInput("Select a number between 1 and 10 for your quote\nType in number: ") - 1;
        System.out.println(famousQuotes[userNumber]);
    }

    public static int geIntInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        int input = Integer.parseInt(scanner.next());
        scanner.nextLine();
        return input;
    }
}
