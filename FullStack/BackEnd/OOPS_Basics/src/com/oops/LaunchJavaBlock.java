package com.oops;

class Car {
    private String brand;
    private double cost;
    static int count;
    
    {
        count++;
    }
    Car() {
    }

    Car(String brand, double cost) {
        this.brand = brand;
        this.cost = cost;
    }

    Car(String brand) {
        this.brand = brand;
    }
}

public class LaunchJavaBlock {
    public static void main(String[] args) {
        // WAP to count number of object created
        Car c1 = new Car("BMW" , 1000000);
        Car c2 = new Car("BENZ" , 2000000);
        Car c3 = new Car("Maruti");

        System.out.println(Car.count);
    }
}
