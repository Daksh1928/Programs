package com.Student.console;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer readInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public Integer readIntegerNullable(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isBlank()) {
            return null;
        }
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Keeping existing value.");
            return null;
        }
    }

    public String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
