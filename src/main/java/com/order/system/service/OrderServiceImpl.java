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
    Map<Long, Integer> menuCard = new HashMap<>();

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
                List<Item> orderedItems = itemService.getItemsById(menuCard.keySet());
                List<Order> orderList = new ArrayList<>();
                for (Item orderedItem : orderedItems) {
                    int orderedQuantity = menuCard.get(orderedItem.getId());
                    if (!isSellable(orderedItem, orderedQuantity)) {
                        ResultView.outOfStockItem(orderedItem, orderedQuantity);
                        process();
                        return;
                    }
                    orderList.add(new Order(orderedItem, orderedQuantity));
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

    private boolean isSellable(Item item, int orderedQuantity) {
        return item.hasSellableStock(orderedQuantity);
    }

    private void cancel() {
        ResultView.orderCancel();
    }

    private void addItemToMenuCard(String[] itemIdAndQuantity) {
        menuCard.put(Long.parseLong(itemIdAndQuantity[0]), Integer.parseInt(itemIdAndQuantity[1]));
    }
}
