package com.order.system;

import com.order.system.domain.Category;
import com.order.system.domain.Item;
import com.order.system.domain.Order;
import com.order.system.domain.Orders;
import com.order.system.view.InputView;
import com.order.system.view.ResultView;

import java.util.*;

public class Application {
    List<Category> categories;
    List<Item> items;

    public Application() {
        categories = new ArrayList<>();
        categories.add(new Category(1, "의류"));
        categories.add(new Category(2, "가방"));
        categories.add(new Category(3, "신발"));

        items = new ArrayList<>();
        items.add(new Item(1, "나이키 상의", 48000, 1, 5));
        items.add(new Item(2, "아디다스 상의", 38000, 1, 10));

        items.add(new Item(3, "나이키 가방", 98000, 2, 7));
        items.add(new Item(4, "아디다스 가방", 62000, 2, 7));
        items.add(new Item(5, "루이비통 가방", 4200000, 2, 3));

        items.add(new Item(6, "나이키 신발", 92000, 3, 10));
        items.add(new Item(7, "아디다스 신발", 120000, 3, 15));
        items.add(new Item(8, "뉴발란스 신발", 128000, 3, 30));
        items.add(new Item(9, "크록스 신발", 42000, 3, 20));
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.process();
    }

    private void process() {
        String answer = InputView.askingOrder();

        switch (answer) {
            case "o" :
                long categoryId = InputView.categoryId(categories);
                List<Item> items = getItemsByCategoryId(categoryId);
                String[] itemIdAndQuantity = InputView.itemIdAndQuantity(items).split(" ");
                Item item = getItemById(Long.parseLong(itemIdAndQuantity[0]));
                Orders orders = new Orders(Collections.singletonList(new Order(item, Long.parseLong(itemIdAndQuantity[1]))));
                ResultView.orderList(orders);
                break;
            case "q" :
                ResultView.orderCancel();
                break;
            default :
                System.out.println("올바른 값을 입력하십시오.");
                process();
        }
    }

    private Item getItemById(long itemId) {
        for (Item item : items) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        return null;
    }

    private List<Item> getItemsByCategoryId(long categoryId) {
        List<Item> list = new ArrayList<>();
        for (Item item : items) {
            if (item.isSameCategory(categoryId)) {
                list.add(item);
            }
        }
        return list;
    }
}
