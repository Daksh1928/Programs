package com.oops;

class Calc3
{
    double add(int a, double b){
         return a+b;
    }
    double add(double a, int b){
         return a+b;
    }
}
public class LaunchMO2 {
     public static void main(String[] args) {
        Calc3 c = new Calc3();
        //The method add(int, double) is ambiguous for the type Calc3
        System.out.println(c.add(2, 4.5));
        main(5);
     }
// ## We can also apply method overriding on main method but the complier 
//    of java is desgine as it call main method with (String[] args)
//    other method with diff parameter we have to call manually
     public static void main(int args) {
        System.out.println("Main method with int parameter ");
        main("Call Main", args);
     }

     public static void main(String args,int b) {
        System.out.println("Main method with stirng and int parameter ");
        main(b,3);
     }

     public static void main(int args, int b) {
        System.out.println("Main method with two int parameter ");
     }
}
