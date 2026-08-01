package com.Student.console;

import com.Student.model.Student;
import com.Student.service.StudentService;

public class CreateStudentHandler {
    private final StudentService service;

    public CreateStudentHandler(StudentService service) {
        this.service = service;
    }

    public void run(ConsoleInput input) {
        System.out.println("--- Add Student ---");
        Integer id = input.readInteger("Enter student ID: ");
        String name = input.readText("Enter name: ");
        String city = input.readText("Enter city: ");
        Integer marks = input.readInteger("Enter marks (0-100): ");

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setCity(city);
        student.setMarks(marks);

        service.save(student);
        System.out.println("Saved: " + student);
    }
}
