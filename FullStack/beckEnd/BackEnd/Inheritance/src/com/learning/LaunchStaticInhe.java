package com.learning;

class Animal1 
{
    static int age;
    static void disp()
    {
        System.out.println("Parent class static method ");
    }
}

class Deer extends Animal1
{

}

public class LaunchStaticInhe {

     public static void main(String[] args) {
        Animal1 a = new Deer();
        a.disp();
     }
}




// Static variable do participate in inheritance 

// Method hiding 

// We create final virable as static for better memory managment 