package com.oops;

class Employee {
    private int age; // instance variables, fields, data memebers
    private String name;

    void setage(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    void setName(String name) {
        this.name = name;
    }

    int getage() {
        return this.age;
    }

    String getName() {
        return this.name;
    }
}

public class LaunchEncap {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setage(19);
        e.setName("Devanshu");
        System.out.println(e.getName());
        System.out.println(e.getage());
    }
}
