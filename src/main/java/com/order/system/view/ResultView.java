package com.order.system.view;

import com.order.system.domain.Item;
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

    public static void outOfStockItem(Item item, int orderedQuantity) {
        System.out.println("-----------------------------------------------------------");
        System.out.printf("주문하신 [ %s ] 상품의 재고가 부족합니다.%n", item.getName());
        System.out.printf("재고 수량: %d%n", item.getStock());
        System.out.printf("주문 수량: %d%n", orderedQuantity);
        System.out.println("이용해 주셔서 감사합니다.");
        System.out.println("-----------------------------------------------------------");
    }
}
