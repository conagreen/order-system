package com.order.system;

import com.order.system.service.OrderService;
import com.order.system.service.OrderServiceImpl;

public class Application {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        orderService.process();
    }
}
