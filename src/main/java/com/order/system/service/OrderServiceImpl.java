package com.order.system.service;

import com.order.system.domain.Item;
import com.order.system.domain.Order;
import com.order.system.domain.Orders;
import com.order.system.domain.strategy.OrderStrategy;
import com.order.system.exception.SoldOutException;
import com.order.system.view.ResultView;

import java.util.*;

public class OrderServiceImpl implements OrderService {
    private CategoryService categoryService;
    private ItemService itemService;
    private OrderStrategy orderStrategy;
    private Map<Long, Integer> menuCard;

    public OrderServiceImpl(CategoryService categoryService, ItemService itemService, OrderStrategy orderStrategy, Map<Long, Integer> menuCard) {
        this.categoryService = categoryService;
        this.itemService = itemService;
        this.orderStrategy = orderStrategy;
        this.menuCard = menuCard;
    }

    @Override
    public void process() {
        long categoryId = categoryService.getSelectedCategoryId();
        String[] itemIdAndQuantity = itemService.getSelectedItemIdAndQuantity(categoryId);
        switch (itemIdAndQuantity[0]) {
            case "p":
                process();
                break;
            case "y":
                List<Order> orderList;
                try {
                    orderList = order(menuCard);
                } catch (SoldOutException e) {
                    ResultView.outOfStockItem();
                    process();
                    return;
                }
                if (orderList == null) {
                    return;
                }
                Orders orders = new Orders(orderList, orderStrategy);
                ResultView.orderList(orders);
                break;
            case "q":
                ResultView.orderCancel();
                break;
            default:
                addItemToMenuCard(itemIdAndQuantity);
                process();
        }
    }

    @Override
    public synchronized List<Order> order(Map<Long, Integer> menuCard) {
        List<Item> orderedItems = itemService.getItemsById(menuCard.keySet());
        List<Order> orderList = new ArrayList<>();
        for (Item orderedItem : orderedItems) {
            int orderedQuantity = menuCard.get(orderedItem.getId());
            if (isSellable(orderedItem.getId(), orderedQuantity)) {
                orderedItem.sellStock(orderedQuantity);
            } else {
                throw new SoldOutException();
            }
            orderList.add(new Order(orderedItem, orderedQuantity));
        }
        return orderList;
    }

    private boolean isSellable(long itemId, int orderedQuantity) {
        final Item item = itemService.getItem(itemId);
        return item.getStock() >= orderedQuantity;
    }

    private void addItemToMenuCard(String[] itemIdAndQuantity) {
        menuCard.put(Long.parseLong(itemIdAndQuantity[0]), Integer.parseInt(itemIdAndQuantity[1]));
    }
}
