package com.order.system.domain;

import com.order.system.domain.strategy.OrderStrategy;
import lombok.Getter;

import java.util.List;

@Getter
public class Orders {
    private List<Order> orders;

    private long orderAmount;

    private long paymentAmount;

    private long deliveryFee;

    public Orders(List<Order> orders, OrderStrategy orderStrategy) {
        this.orders = orders;
        this.orderAmount = calculateOrderAmount();
        this.deliveryFee = orderStrategy.calculateDeliveryFee(orderAmount);
        this.paymentAmount = calculatePaymentAmount();
    }

    private long calculatePaymentAmount() {
        return orderAmount + deliveryFee;
    }

    private long calculateOrderAmount() {
        long orderAmount = 0;
        for (Order order : orders) {
            orderAmount += order.getTotalAmount();
        }
        return orderAmount;
    }

    public boolean hasDeliveryFee() {
        return deliveryFee > 0;
    }
}
