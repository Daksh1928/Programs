package main;

import service.DevOps;
import service.SystemDesign;

public class LaunchSpring2 {
    public static void main(String[] args) {
        // Constructor injection
        Telusko t = new Telusko(new DevOps());

        // Telusko t = new Telusko();// target
        // injectiong dependent object into target ==> DI
        // setter injection
        t.setCourse(new SystemDesign());

        boolean status = t.buyTheCourse();
        if (status)
            System.out.println("Successfully registered at telusko ");
        else
            System.out.println("ERROR : 404");
    }
}
