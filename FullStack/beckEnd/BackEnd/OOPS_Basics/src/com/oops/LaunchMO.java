//Method overloading
//Method overloading is also known as false 
//polymophism or compile time polymorphism
package com.oops;

class Calc2 {
    int add(int n1, int n2) {
        int res = n1 + n2;
        return res;
    }

    int add(int n1, int n2, int n3) {
        int res = n1 + n2 + n3;
        return res;
    }

    float add(float n1, float n2) {
        float res = n1 + n2;
        return res;
    }
}

public class LaunchMO {
    public static void main(String[] args) {
        Calc2 c = new Calc2();
        int a = c.add(2, 1);
        System.out.println(a);
    }
}


//  <-------------------####**Notes**####------------------------> 
//  ## Method overloading  --> In java we can write multiple methods
//     in a class with same name but diff parameters
//     It will be resolved by compiler by considering numberof 
//     parameters,data type of parameter order of data type of parameter
