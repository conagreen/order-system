package com.order.system.service;

import com.order.system.domain.Item;
import com.order.system.repository.ItemListRepository;
import com.order.system.repository.ItemRepository;
import com.order.system.view.InputView;

import java.util.*;

public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository = new ItemListRepository();

    @Override
    public String[] getSelectedItemIdAndQuantity(long categoryId) {
        List<Item> items = itemRepository.getItems(categoryId);
        return InputView.itemIdAndQuantity(items).split(" ");
    }

    @Override
    public List<Item> getItemsById(Set<Long> itemIds) {
        List<Item> itemList = new ArrayList<>();
        for (Long itemId : itemIds) {
            itemList.add(itemRepository.getItem(itemId));
        }
        return itemList;
    }
}
