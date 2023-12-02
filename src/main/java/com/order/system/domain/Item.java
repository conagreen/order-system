package com.order.system.domain;

import lombok.Getter;

@Getter
public class Item {
    private long id;
    private String name;
    private long amount;
    private int categoryId;
    private int stock;

    public Item(long id, String name, long amount, int categoryId, int stock) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.categoryId = categoryId;
        this.stock = stock;
    }

    public boolean belongsToCategory(long categoryId) {
        return this.categoryId == categoryId;
    }

    public void sellStock(int quantity) {
        stock = stock - quantity;
    }
}
