package com.order.system.view;

import com.order.system.domain.Order;
import com.order.system.domain.Orders;

public class ResultView {
    public static void orderList(Orders orders) {
        System.out.println("< 주문 내역 >");
        for (Order order : orders.getOrders()) {
            System.out.printf("%s (%d개) - %d원%n", order.getItemName(), order.getQuantity(), order.getTotalPrice());
        }
        System.out.println("-----------------------------------------------------------");
        System.out.printf("주문금액: %d원%n", orders.getOrderAmount());
        if (orders.hasDeliveryFee()) {
            System.out.printf("배송비: %d원%n", orders.getDeliveryCharge());
        }
        System.out.println("-----------------------------------------------------------");
        System.out.printf("지불금액: %d원%n", orders.getPaymentAmount());
    }

    public static void orderCancel() {
        System.out.println("주문을 종료합니다. 감사합니다.");
    }
}
