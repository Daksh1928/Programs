package mainservice;

public class Zomato implements IDelivery {
    public String deliverd(double amount) {
        return "Order is delivered through Zomato service " + amount;
    }
}
