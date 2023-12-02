package com.order.system.repository;

import com.order.system.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemListRepository implements ItemRepository {
    private static List<Item> items;

    public ItemListRepository() {
        init();
    }

    @Override
    public Item getItem(long id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Item> getItems(long categoryId) {
        List<Item> list = new ArrayList<>();
        for (Item item : items) {
            if (item.belongsToCategory(categoryId)) {
                list.add(item);
            }
        }
        return list;
    }

    @Override
    public void init() {
        items = new ArrayList<>();
        items.add(new Item(1532, "나이키 상의", 48000, 1, 5));
        items.add(new Item(2876, "아디다스 상의", 38000, 1, 10));

        items.add(new Item(3143, "나이키 가방", 98000, 2, 7));
        items.add(new Item(2422, "아디다스 가방", 62000, 2, 7));
        items.add(new Item(2534, "루이비통 가방", 4200000, 2, 3));

        items.add(new Item(3326, "나이키 신발", 92000, 3, 10));
        items.add(new Item(1734, "아디다스 신발", 120000, 3, 15));
        items.add(new Item(8322, "뉴발란스 신발", 128000, 3, 30));
        items.add(new Item(1292, "크록스 신발", 42000, 3, 20));
    }
}
