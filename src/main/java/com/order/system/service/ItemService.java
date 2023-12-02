package com.order.system.service;

import com.order.system.domain.Item;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ItemService {
    String[] getSelectedItemIdAndQuantity(long categoryId);

    List<Item> getItemsById(Set<Long> itemIds);

    Item getItem(long itemId);
}
