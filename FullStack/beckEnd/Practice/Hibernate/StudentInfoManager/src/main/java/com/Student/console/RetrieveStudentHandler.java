package com.Student.console;

import java.util.Optional;

import com.Student.model.Student;
import com.Student.service.StudentService;

public class RetrieveStudentHandler {
    private final StudentService service;

    public RetrieveStudentHandler(StudentService service) {
        this.service = service;
    }

    public void run(ConsoleInput input) {
        System.out.println("--- Retrieve Student ---");
        Integer id = input.readInteger("Enter student ID: ");
        Optional<Student> optional = service.findById(id);
        optional.ifPresentOrElse(
                student -> System.out.println("Found: " + student),
                () -> System.out.println("Student not found."));
    }
}
