package main;

import service.DevOps;
import service.ICourse;

public class Telusko {
    public Telusko(ICourse course){
        super();
        this.course = course;
    }
    public Telusko(){
        super();
    }
    private ICourse course;

    public void setCourse(ICourse course) {
        this.course = course;
    }

    public boolean buyTheCourse() {
        return course.registerCourse();
    }
}
