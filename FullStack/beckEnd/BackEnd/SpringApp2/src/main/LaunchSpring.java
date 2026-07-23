package main;

import mainservice.Amazon;
import mainservice.Flipkart;


public class LaunchSpring {
    public static void main(String[] args) {
    Myntra myntra = new Myntra(new Flipkart());
    myntra.setDelivery(new Amazon());

    String status = myntra.orderDelivery(4455.66);
    System.out.println(status);
    }
}
