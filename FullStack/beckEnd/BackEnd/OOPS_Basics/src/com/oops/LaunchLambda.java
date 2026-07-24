package com.oops;

// Functional interface
@FunctionalInterface
interface Alien {
    void disp(); // SAM single abstract method
}

class AlienImpl implements Alien {
    public void disp() {
        System.out.println("Disp form alien implemented");
    }
}

public class LaunchLambda {
    public static void main(String[] args) {
        Alien al = new AlienImpl();
        al.disp();

        // anonymous inner class

    }
}


// Lambda expression is tightly copuled with functional interface