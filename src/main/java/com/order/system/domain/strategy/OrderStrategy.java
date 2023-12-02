package com.order.system.domain.strategy;

public interface OrderStrategy {
    long calculateDeliveryFee(long orderAmount);
}
