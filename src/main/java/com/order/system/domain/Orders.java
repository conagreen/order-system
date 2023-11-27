package com.order.system.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Orders {
    private List<Order> orders;

    private long deliveryCharge;

    private long orderAmount;

    private long paymentAmount;

    public Orders(List<Order> orders) {
        this.orders = orders;
        this.deliveryCharge = 0;
        this.orderAmount = createOrderAmount();
        this.paymentAmount = createPaymentAmount();
    }

    private long createPaymentAmount() {
        return orderAmount + deliveryCharge;
    }

    private long createOrderAmount() {
        long orderAmount = 0;
        for (Order order : orders) {
            orderAmount += order.getTotalPrice();
        }
        return orderAmount;
    }

    public boolean hasDeliveryFee() {
        return deliveryCharge > 0;
    }
}
