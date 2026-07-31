package com.Student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentInfoTable") 
public class Student {
    @Id
    @Column(name = "SId")
    private Integer Id;
    @Column(name = "SName")
    private String Name;
    @Column(name = "SCity")
    private String City;
    @Column(name = "SMarks")
    private Integer Marks;

    public Student() {
        System.out.println("Object created ");
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Integer getMarks() {
        return Marks;
    }

    public void setMarks(Integer marks) {
        Marks = marks;
    }

    @Override
    public String toString() {
        return "Student [Id=" + Id + ", Name=" + Name + ", City=" + City + ", Marks=" + Marks + ", getId()=" + getId()
                + ", getName()=" + getName() + ", getCity()=" + getCity() + ", getMarks()=" + getMarks()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }

}
