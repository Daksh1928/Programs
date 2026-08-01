package com.Student.app;

import java.util.Scanner;

import com.Student.console.ConsoleInput;
import com.Student.console.CreateStudentHandler;
import com.Student.console.DeleteStudentHandler;
import com.Student.console.ListStudentsHandler;
import com.Student.console.RetrieveStudentHandler;
import com.Student.console.UpdateStudentHandler;
import com.Student.service.StudentService;
import com.Student.util.HibernateUtil;

public class LaunchStudentInfoApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService service = new StudentService();
    private static final ConsoleInput input = new ConsoleInput(scanner);
    private static final CreateStudentHandler createHandler = new CreateStudentHandler(service);
    private static final UpdateStudentHandler updateHandler = new UpdateStudentHandler(service);
    private static final DeleteStudentHandler deleteHandler = new DeleteStudentHandler(service);
    private static final RetrieveStudentHandler retrieveHandler = new RetrieveStudentHandler(service);
    private static final ListStudentsHandler listHandler = new ListStudentsHandler(service);

    public static void main(String... args) {
        try {
            runMenu();
        } catch (Exception e) {
            System.out.println("Unable to start Student Info Manager.");
            System.out.println(e.getMessage());
        } finally {
            try {
                HibernateUtil.shutdown();
            } catch (Exception ignored) {
                // Ignore shutdown errors during exit.
            }
            scanner.close();
        }
    }

    private static void runMenu() {
        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> createHandler.run(input);
                case "2" -> updateHandler.run(input);
                case "3" -> deleteHandler.run(input);
                case "4" -> retrieveHandler.run(input);
                case "5" -> listHandler.listAll();
                case "6" -> listHandler.listByGrade(input);
                case "7" -> {
                    System.out.println("Goodbye.");
                    return;
                }
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== Student Info Manager ===");
        System.out.println("1. Add student");
        System.out.println("2. Update student");
        System.out.println("3. Delete student");
        System.out.println("4. Retrieve student by ID");
        System.out.println("5. List all students");
        System.out.println("6. List students by grade");
        System.out.println("7. Exit");
        System.out.print("Select an option: ");
    }
}
