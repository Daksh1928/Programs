package com.grade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Implementing Comparable allows us to easily sort the students
class Student implements Comparable<Student> {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    // Feature: Calculate letter grade based on the numeric score
    public String getLetterGrade() {
        if (grade >= 90)
            return "A";
        else if (grade >= 80)
            return "B";
        else if (grade >= 70)
            return "C";
        else if (grade >= 60)
            return "D";
        else
            return "F";
    }

    // Sort in descending order (Highest grade first)
    @Override
    public int compareTo(Student other) {
        return Double.compare(other.grade, this.grade);
    }
}

public class GradeTracker {
    // Shared list accessible by all methods
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("=== Enhanced Student Grade Tracker ===");

        // Main Application Menu
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a Student");
            System.out.println("2. View All Students (Sorted)");
            System.out.println("3. View Class Statistics");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    displayAllStudents();
                    break;
                case "3":
                    displayStatistics();
                    break;
                case "4":
                    System.out.println("Exiting tracker. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
            }
        }
        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        // Input Validation Loop
        double grade = -1;
        while (grade < 0 || grade > 100) {
            System.out.print("Enter grade for " + name + " (0-100): ");
            try {
                // Parsing as a string prevents the newline buffer bug entirely
                grade = Double.parseDouble(scanner.nextLine());
                if (grade < 0 || grade > 100) {
                    System.out.println("Error: Grade must be between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                grade = -1; // Reset to keep the loop going
            }
        }

        students.add(new Student(name, grade));
        System.out.println("Successfully added " + name + "!");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system yet. Please add some first.");
            return;
        }

        // Sort the list from highest to lowest before displaying
        Collections.sort(students);

        System.out.println("\n=== Complete Student Roster ===");
        System.out.printf("%-20s %-10s %s\n", "Student Name", "Grade", "Letter");
        System.out.println("----------------------------------------");

        for (Student s : students) {
            System.out.printf("%-20s %-10.2f %s\n", s.getName(), s.getGrade(), s.getLetterGrade());
        }
        System.out.println("----------------------------------------");
    }

    private static void displayStatistics() {
        if (students.isEmpty()) {
            System.out.println("No data available to calculate statistics.");
            return;
        }

        double sum = 0;
        double highest = students.get(0).getGrade();
        double lowest = students.get(0).getGrade();
        String highestStudent = students.get(0).getName();
        String lowestStudent = students.get(0).getName();

        for (Student s : students) {
            double currentGrade = s.getGrade();
            sum += currentGrade;

            if (currentGrade > highest) {
                highest = currentGrade;
                highestStudent = s.getName();
            }
            if (currentGrade < lowest) {
                lowest = currentGrade;
                lowestStudent = s.getName();
            }
        }

        double average = sum / students.size();

        System.out.println("\n=== Class Statistics ===");
        System.out.printf("Total Students: %d\n", students.size());
        System.out.printf("Class Average:  %.2f\n", average);
        System.out.printf("Highest Score:  %.2f (%s)\n", highest, highestStudent);
        System.out.printf("Lowest Score:   %.2f (%s)\n", lowest, lowestStudent);
        System.out.println("========================");
    }
}