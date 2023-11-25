package com.order.system;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Item {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer categoryId;
    private Long quantity;

    public Item(Long id, String name, BigDecimal price, Integer categoryId, Long quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.quantity = quantity;
    }
}
