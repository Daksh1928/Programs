package com.learning;

class Airport {
    public void permit(AreoPlane aero) {
        aero.takeOff();
        aero.fly();
    }
}

abstract class AreoPlane {
    public abstract void takeOff();

    public abstract void fly();
}

class CargePlane extends AreoPlane {
    public void takeOff() {
        System.out.println("CargoPalne reqrire longer runway to taking off");
    }

    public void fly() {
        System.out.println("CargoPlane fly at lower altitude");
    }
}

class FighterPlane extends AreoPlane {
    public void takeOff() {
        System.out.println("FighterPalne requires short runway to taking off");
    }

    public void fly() {
        System.out.println("FighterPlane fly at higher altitude");
    }
}

class CommercialPlane extends AreoPlane {
    public void takeOff() {
        System.out.println("CommercialPalne requires short runway to taking off");
    }

    public void fly() {
        System.out.println("CommercialPlane fly at medium altitude");
    }
}

public class LaunchPolymorphism {
    public static void main(String[] args) {
        CargePlane cp = new CargePlane();
        FighterPlane fp = new FighterPlane();
        CommercialPlane p = new CommercialPlane();
        Airport a = new Airport();
        a.permit(cp);
        a.permit(fp);
        a.permit(p);
        // AreoPlane aero;
        // aero = cp;
        // aero.takeOff();
        // aero.fly();
        // System.out.println("Fighter Plane ");
        // aero = fp;
        // aero.takeOff();
        // aero.fly();
    }
}


// we can object of abstract class 
// variable, constructor can't be abstract 