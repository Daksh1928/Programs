package com.Student.test;
import com.Student.model.Student;
import com.Student.service.StudentService;
public class DbCheck {
  public static void main(String[] args) {
    Student s = new Student();
    s.setId(20002);
    s.setName("FrontEndCheck");
    s.setCity("Mumbai");
    s.setMarks(92);
    new StudentService().save(s);
    System.out.println("saved");
  }
}
