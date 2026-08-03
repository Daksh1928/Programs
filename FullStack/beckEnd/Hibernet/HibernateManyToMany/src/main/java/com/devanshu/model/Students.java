package com.devanshu.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Students {
    @Id
    @Column(name = "student_id")
    private Integer studentId;
    private String studentName;
    private String city;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Courses> courses;

    public Set<Courses> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Students [studentId=" + studentId + ", studentName=" + studentName + ", city=" + city + ", courses="
                + courses + "]";
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    public Students() {
        System.out.println("Student Object Created");
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
