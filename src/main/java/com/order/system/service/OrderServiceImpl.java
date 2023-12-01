package com.order.system.service;

import com.order.system.domain.Item;
import com.order.system.domain.Order;
import com.order.system.domain.Orders;
import com.order.system.view.InputView;
import com.order.system.view.ResultView;

import java.util.*;

public class OrderServiceImpl implements OrderService {
    private CategoryService categoryService = new CategoryServiceImpl();
    private ItemService itemService = new ItemServiceImpl();
    Map<Integer, Integer> menuCard = new HashMap<>();

    @Override
    public void process() {
        String answer = InputView.askingOrder();
        switch (answer) {
            case "o":
                order();
                break;
            case "q":
                cancel();
                break;
            default:
                System.out.println("올바른 값을 입력하십시오.");
                process();
        }
    }

    private void order() {
        long categoryId = categoryService.getSelectedCategoryId();
        String[] itemIdAndQuantity = itemService.getSelectedItemIdAndQuantity(categoryId);
        switch (itemIdAndQuantity[0]) {
            case "p":
                order();
                break;
            case "y":
                Map<Item, Integer> orderedItems = itemService.getOrderedItems(menuCard);
                List<Order> orderList = new ArrayList<>();
                for (Map.Entry<Item, Integer> orderedItem : orderedItems.entrySet()) {
                    orderList.add(new Order(orderedItem.getKey(), orderedItem.getValue()));
                }
                Orders orders = new Orders(orderList);
                ResultView.orderList(orders);
                break;
            case "q":
                cancel();
                break;
            default:
                addItemToMenuCard(itemIdAndQuantity);
                order();
        }
    }

    private void cancel() {
        ResultView.orderCancel();
    }

    private void addItemToMenuCard(String[] itemIdAndQuantity) {
        menuCard.put(Integer.parseInt(itemIdAndQuantity[0]), Integer.parseInt(itemIdAndQuantity[1]));
    }
}
