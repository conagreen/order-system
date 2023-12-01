package com.order.system.service;

import com.order.system.domain.Item;
import com.order.system.repository.ItemListRepository;
import com.order.system.repository.ItemRepository;
import com.order.system.view.InputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository = new ItemListRepository();

    @Override
    public String[] getSelectedItemIdAndQuantity(long categoryId) {
        List<Item> items = itemRepository.getItems(categoryId);
        return InputView.itemIdAndQuantity(items).split(" ");
    }

    @Override
    public Map<Item, Integer> getOrderedItems(Map<Integer, Integer> menuCard) {
        Map<Item, Integer> orderedItems = new HashMap<>();
        for (Map.Entry<Integer, Integer> menu : menuCard.entrySet()) {
            orderedItems.put(itemRepository.getItem(menu.getKey()), menu.getValue());
        }
        return orderedItems;
    }
}
