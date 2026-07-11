package com.oops;

class Telusko {
    private String name;
    private double cost;

    Telusko() {
        System.out.println("Object created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

public class LaunchConstructor1 {
    public static void main(String[] args) {
        Telusko t1 = new Telusko();
        t1.setCost(1000.0);
        t1.setName("DevOps");
        System.out.println(t1.getCost());
        System.out.println(t1.getName());
    }
}
// constructor get called at the time of object creating