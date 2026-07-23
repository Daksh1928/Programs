package mainservice;

public class Amazon implements IDelivery {
    public String deliverd(double amount) {
        return "Order is delivered through Amazon service " + amount;
    }
}
