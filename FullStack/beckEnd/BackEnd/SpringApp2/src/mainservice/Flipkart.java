package mainservice;

public class Flipkart implements IDelivery {
    public String deliverd(double amount) {
        return "Order is delivered through Flipkart service " + amount;
    }
}
