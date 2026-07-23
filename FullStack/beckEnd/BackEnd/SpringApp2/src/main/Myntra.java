package main;

import mainservice.IDelivery;

public class Myntra {

    private IDelivery delivery;

    public void setDelivery(IDelivery delivery) {
        this.delivery = delivery;
    }

    public Myntra(IDelivery delivery) {
        super();
        this.delivery = delivery;
    }

    public Myntra() {
        super();
    }

    public String orderDelivery(double amount) {
         return delivery.deliverd(amount);
    }

}
