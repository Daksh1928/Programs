package com.Student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StudentInfoTable")
public class Student {
    @Id
    @Column(name = "SId")
    private Integer id;

    @Column(name = "SName")
    private String name;

    @Column(name = "SCity")
    private String city;

    @Column(name = "SMarks")
    private Integer marks;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getGrade() {
        if (marks == null) {
            return "N/A";
        }
        if (marks >= 90)
            return "A+";
        if (marks >= 80)
            return "A";
        if (marks >= 70)
            return "B+";
        if (marks >= 60)
            return "B";
        if (marks >= 50)
            return "C";
        if (marks >= 40)
            return "D";
        return "F-";
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', city='%s', marks=%d, grade='%s'}",
                id, name, city, marks, getGrade());
    }
}
