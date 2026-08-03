package com.devanshu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Courses {
    @Id
    @Column(name = "course_id")
    private Integer courseId;

    private String courseName;
    private Integer coursePrice;

    public Courses() {
        System.out.println("Course Object Created");
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice + "]";
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Integer coursePrice) {
        this.coursePrice = coursePrice;
    }

}
