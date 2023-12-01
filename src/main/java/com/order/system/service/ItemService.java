package com.order.system.service;

import com.order.system.domain.Item;

import java.util.Map;

public interface ItemService {
    String[] getSelectedItemIdAndQuantity(long categoryId);

    Map<Item, Integer> getOrderedItems(Map<Integer, Integer> menuCard);
}
