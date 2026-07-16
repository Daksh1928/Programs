package com.oops;

class Dog {
    // instance variable
    // scope is entire class
    // default values will be assigned int --> 0 String --> null double --> 0.0
    // boolean --> false
    // Local variable dosn't have any default values
    int cost;
    // cost == 0;
    String name;

    // name = null;
    void barks() {

        System.out.println("dog barking " + name);
        cost = 434334;
    }

    void run() {
        name = "labra";
        // age = 5;
        System.out.println("Dog runs besides motor bikes ");
    }

}

public class LaunchOOP2 {
    public static void main(String[] args) {
        Dog doog = new Dog();
        doog.cost = 10000;
        doog.name = "labra";
        doog.barks();
        doog.run();
        Dog dog = new Dog();
        dog.cost = 1200;
        dog.name = "Gernam";
        dog.barks();
        dog.run();
    }
}
