package com.order.system.domain;

import com.order.system.util.IdGenerator;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Order {
    private long id;

    private long itemId;

    private long quantity;

    private long totalPrice;

    private String itemName;

    private LocalDateTime orderDate;

    public Order(Item item, long quantity) {
        this.id = IdGenerator.orderId();
        this.itemId = item.getId();
        this.quantity = quantity;
        this.totalPrice = item.getPrice() * quantity;
        this.itemName = item.getName();
        this.orderDate = LocalDateTime.now();
    }
}
