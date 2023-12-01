package com.order.system.repository;

import com.order.system.domain.Item;

import java.util.List;

public interface ItemRepository {
    void init();
    Item getItem(long id);
    List<Item> getItems(long categoryId);
}
