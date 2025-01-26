package search;

import java.util.Scanner;

public class UserInterface {
    public static Scanner scanner = new Scanner(System.in);

    private static String askForString() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Please enter a valid string");
            }
        }
    }

    public static String askForAction() {
        System.out.println("""
                === Menu ===
                1. Find a person
                2. Print all people
                0. Exit
                """);
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("[012]")) {
                return input;
            } else {
                System.out.println("Incorrect option! Try again.");
            }
        }
    }

    public static String askForSearchingStrategy() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        while (true) {
            String input = askForString();
            if (input.matches("ALL|ANY|NONE")) {
                return input;
            } else {
                System.out.println("Incorrect searching strategy! Try again.");
            }
        }
    }

    public static String askForSearchQuery() {
        System.out.println("Enter a name or email to search all suitable people.");
        return askForString();
    }
}
