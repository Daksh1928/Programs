package com.oops;

class Calc {
    int n1, n2, n3, res;

    // void multiply(){
    // n1 =2 ;
    // n2 = 3;
    // n3 = 4;
    // res = n1*n2*n3;
    // System.out.println("Result : "+res);
    // }
    int multiply(int a, int b, int c) {// parameter

        n1 = a;
        n2 = b;
        n3 = c;
        res = n1 * n2 * n3;
        return res;
    }

}

public class LaunchMethods {
    public static void main(String[] args) {
        Calc c = new Calc();
        int res = c.multiply(14, 24, 34);// arguments
        System.out.println("Result is : " + res);
    }
}
