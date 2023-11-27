package com.order.system.domain;

import lombok.Getter;

@Getter
public class Category {
    private long id;
    private String name;

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
