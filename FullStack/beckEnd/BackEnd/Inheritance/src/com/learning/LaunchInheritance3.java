package com.learning;

class TeluskoMain {

}

class TeluskoAI extends TeluskoMain {

}

class Animal {
    public void eat() {
        System.out.println("Animal is eating ");
    }

    public int age() {
        return 8;
    }

    public TeluskoMain animalLearn() {
        TeluskoMain t = new TeluskoMain();
        return t;
    }

}

class Tiger extends Animal {
    public void eat() {
        System.out.println("Tiger is eating ");
    }

    public int age() {
        return 10;
    }

    public TeluskoAI animalLearn() {
        TeluskoAI tA = new TeluskoAI();
        return tA;
    }

}

public class LaunchInheritance3 {
    public static void main(String[] args) {
        Animal a = new Animal();
        System.out.println(a.age());
        a.animalLearn();
        a.eat();
    }
}

// 1. We cannot decrease visibility of overridden methods in child class however
// we can increase visibility
// 2. We cannot return type of overridden method in child class
// 3. We can change return type of overridden method in child class if its
// co-variant return type
// 4. We can't change parameter list of overridden method in child class if we
// change it will be treated as specialized method

// What is co-veriant in Java ?
