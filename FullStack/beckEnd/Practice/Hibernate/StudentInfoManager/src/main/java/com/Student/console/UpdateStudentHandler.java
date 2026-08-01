package com.Student.console;

import java.util.Optional;

import com.Student.model.Student;
import com.Student.service.StudentService;

public class UpdateStudentHandler {
    private final StudentService service;

    public UpdateStudentHandler(StudentService service) {
        this.service = service;
    }

    public void run(ConsoleInput input) {
        System.out.println("--- Update Student ---");
        Integer id = input.readInteger("Enter student ID to update: ");
        Optional<Student> optional = service.findById(id);
        if (optional.isEmpty()) {
            System.out.println("Student not found.");
            return;
        }

        Student student = optional.get();
        System.out.println("Current: " + student);
        String name = input.readText("Enter new name (leave blank to keep): ");
        String city = input.readText("Enter new city (leave blank to keep): ");
        Integer marks = input.readIntegerNullable("Enter new marks (leave blank to keep): ");

        if (!name.isBlank()) {
            student.setName(name);
        }
        if (!city.isBlank()) {
            student.setCity(city);
        }
        if (marks != null) {
            student.setMarks(marks);
        }

        service.update(student);
        System.out.println("Updated: " + student);
    }
}
