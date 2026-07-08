package com.oops;

class Student {
    int id;
    double age;
    String name;

    void sleep() {
        System.out.println("Student is sleeping ");
    }

    void study() {
        System.out.println("Student must study ");
    }
}

public class LaunchOOP1 {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.sleep();
        stu.study();
    }
}
