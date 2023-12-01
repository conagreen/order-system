package com.order.system.domain;

import lombok.Getter;

@Getter
public class Item {
    private long id;
    private String name;
    private long price;
    private int categoryId;
    private int quantity;

    public Item(long id, String name, long price, int categoryId, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.quantity = quantity;
    }

    public boolean belongsToCategory(long categoryId) {
        return this.categoryId == categoryId;
    }
}
