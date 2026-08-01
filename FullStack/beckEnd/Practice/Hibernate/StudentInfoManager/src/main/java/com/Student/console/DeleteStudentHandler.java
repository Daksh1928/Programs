package com.Student.console;

import com.Student.service.StudentService;

public class DeleteStudentHandler {
    private final StudentService service;

    public DeleteStudentHandler(StudentService service) {
        this.service = service;
    }

    public void run(ConsoleInput input) {
        System.out.println("--- Delete Student ---");
        Integer id = input.readInteger("Enter student ID to delete: ");
        if (service.deleteById(id)) {
            System.out.println("Deleted student with ID " + id);
        } else {
            System.out.println("Student not found.");
        }
    }
}
