package com.Student.console;

import java.util.List;

import com.Student.model.Student;
import com.Student.service.StudentService;

public class ListStudentsHandler {
    private final StudentService service;

    public ListStudentsHandler(StudentService service) {
        this.service = service;
    }

    public void listAll() {
        System.out.println("--- All Students ---");
        List<Student> students = service.findAll();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        students.forEach(System.out::println);
    }

    public void listByGrade(ConsoleInput input) {
        System.out.println("--- Students by Grade ---");
        String grade = input.readText("Enter grade (A+, A, B+, B, C, D, F-): ").toUpperCase();
        List<Student> students = service.findByGrade(grade);
        if (students.isEmpty()) {
            System.out.println("No students found with grade " + grade);
            return;
        }
        students.forEach(System.out::println);
    }
}
