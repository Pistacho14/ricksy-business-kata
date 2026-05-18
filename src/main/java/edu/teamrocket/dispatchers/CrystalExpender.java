package edu.teamrocket.dispatchers;

import edu.teamrocket.payment.PaymentMethod;
import edu.teamrocket.receptivo.GuestDispatcher;

public class CrystalExpender implements GuestDispatcher {
    private int stock;
    private double itemCost;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public void dispatch(PaymentMethod usuario) {
        if (this.stock > 0 && usuario.pay(getItemCost())) {
            this.stock -= 1;
        }
    }

    public int stock() {
        return this.stock;
    }

    public double getItemCost() {
        return this.itemCost;
    }

    @Override
    public String toString() {
        return """
                stock: %d
                cost: %f
                """.formatted(stock(), getItemCost());
    }

}
