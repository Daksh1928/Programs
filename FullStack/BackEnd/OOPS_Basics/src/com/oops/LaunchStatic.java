package com.oops;

class Demo {
    static int a, b;
    int x, y;

    static {
        System.out.println("Static block init");
    }
    {
        System.out.println("Java init block (non - static )");
    }

    Demo() {
        System.out.println("COnstructor");
    }

    static void disp() {
        System.out.println("Display static methods");
    }

    void show()
    {
        System.out.println("non static show method");
    }
}

public class LaunchStatic {
    public static void main(String[] args) {
    Demo d1 = new Demo();
    
    }
}
