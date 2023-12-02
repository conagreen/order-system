package com.order.system.view;

import com.order.system.domain.Item;
import com.order.system.domain.Order;
import com.order.system.domain.Orders;

public class ResultView {
    public static void orderList(Orders orders) {
        System.out.println("< 주문 내역 >");
        for (Order order : orders.getOrders()) {
            System.out.printf("%s (%d개) - %d원%n", order.getItemName(), order.getQuantity(), order.getTotalAmount());
        }
        System.out.println("-----------------------------------------------------------");
        System.out.printf("주문금액: %d원%n", orders.getOrderAmount());
        if (orders.hasDeliveryFee()) {
            System.out.printf("배송비: %d원%n", orders.getDeliveryFee());
        }
        System.out.println("-----------------------------------------------------------");
        System.out.printf("결제금액: %d원%n", orders.getPaymentAmount());
        System.out.println("-----------------------------------------------------------");
    }

    public static void orderCancel() {
        System.out.println("주문을 종료합니다. 감사합니다.");
    }

    public static void outOfStockItem() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("주문하신 상품의 재고가 부족합니다. 이용해 주셔서 감사합니다.");
        System.out.println("-----------------------------------------------------------");
    }

    public static void wrongAnswer() {
        System.out.println("올바른 값을 입력하십시오.");
    }
}
