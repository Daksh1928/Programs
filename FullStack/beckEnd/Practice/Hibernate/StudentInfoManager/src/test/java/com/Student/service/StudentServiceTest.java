package com.Student.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.Student.model.Student;

public class StudentServiceTest {
    private final StudentService service = new StudentService();

    @Test
    void gradeMappingShouldReturnExpectedValues() {
        Student student = new Student();
        student.setId(1001);
        student.setName("Test Student");
        student.setCity("Test City");
        student.setMarks(95);

        assertEquals("A+", student.getGrade());
        assertEquals("F-", new Student().getGrade());
    }

    @Test
    void canCreateAndFindStudent() {
        Student student = new Student();
        student.setId(1002);
        student.setName("JUnit Student");
        student.setCity("JUnit City");
        student.setMarks(82);

        service.save(student);
        Student loaded = service.findById(1002).orElse(null);
        assertNotNull(loaded);
        assertEquals("A", loaded.getGrade());
        service.deleteById(1002);

        List<Student> all = service.findAll();
        assertEquals(true, all.stream().noneMatch(s -> s.getId().equals(1002)));
    }
}
