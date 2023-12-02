package com.order.system.domain;

import lombok.Getter;

@Getter
public class Item {
    private long id;
    private String name;
    private long price;
    private int categoryId;
    private int stock;

    public Item(long id, String name, long price, int categoryId, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.stock = stock;
    }

    public boolean belongsToCategory(long categoryId) {
        return this.categoryId == categoryId;
    }

    public boolean hasSellableStock(int quantity) {
        return stock - quantity >= 0;
    }
}
