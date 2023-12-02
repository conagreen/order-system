package com.order.system.service;

import com.order.system.domain.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    void process();

    List<Order> order(Map<Long, Integer> menuCard);
}
