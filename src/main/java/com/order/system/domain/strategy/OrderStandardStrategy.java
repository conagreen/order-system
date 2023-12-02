package com.order.system.domain.strategy;

public class  OrderStandardStrategy implements OrderStrategy {
    final long DELIVERY_FEE_SUPPORT_BASE_AMOUNT = 50_000;
    final long DELIVERY_FEE = 2_500;

    @Override
    public long calculateDeliveryFee(long orderAmount) {
        return orderAmount >= DELIVERY_FEE_SUPPORT_BASE_AMOUNT ? 0 : DELIVERY_FEE;
    }
}
