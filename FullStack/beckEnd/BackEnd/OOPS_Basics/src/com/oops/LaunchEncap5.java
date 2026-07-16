package com.oops;

class Student2 {
    private int age;
    private String name;

    void setName(String name) {
        this.name = name;
    }

    void setage(int age) {
        this.age = age;
    }
}

public class LaunchEncap5 {
    public static void main(String[] args) {
        Student2 stu = new Student2();
        stu.setName("Dev");
        stu.setage(19);
        Student2 stu2 = new Student2();
        stu2.setName("Adi");
        stu2.setage(11);
    }
}
