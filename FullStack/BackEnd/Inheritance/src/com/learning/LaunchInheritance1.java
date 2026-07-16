package com.learning;

class Devanshu // Extends Object class
{
    void name() {
        System.out.println("My name is devanshu ");
    }
}

class Alpha extends Devanshu {
    int age;
    String name;

    void disp() {
        System.out.println("Inheritance One void(Alpha) ");
    }
}

class Beta extends Alpha
// Alpha --> Parent/Super/Base
// Beta --> Child/Drived/Sub class
{
    void show() {
        age = 18;
        System.out.println("Inheritance second Beta ");
    }
}

public class LaunchInheritance1 {
    public static void main(String[] args) {
        Beta beta = new Beta();
        beta.disp();
    }
}

// ++++++++++++++++++++++ Notes +++++++++++++++++++++++++

// Private variables, methods, functions can't be inheritated
// By default every class in java Extends Object class
// In Java we have multi level inheritance but we don't have multiple
// inheritacne this problem in Java also known as diamond shape problem it will
// lead to ambiguity
// We can give perent referece to child class 
// Eg. Alpha beta = new Beta();