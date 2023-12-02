package com.order.system;

import com.order.system.domain.strategy.OrderStandardStrategy;
import com.order.system.service.CategoryServiceImpl;
import com.order.system.service.ItemServiceImpl;
import com.order.system.service.OrderService;
import com.order.system.service.OrderServiceImpl;
import com.order.system.view.InputView;
import com.order.system.view.ResultView;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl(
                new CategoryServiceImpl(), new ItemServiceImpl(), new OrderStandardStrategy(), new HashMap<>());

        boolean flag = true;
        while (flag) {
            String answer = InputView.askingOrder();
            switch (answer) {
                case "o":
                    orderService.process();
                    break;
                case "q":
                    ResultView.orderCancel();
                    flag = false;
                    break;
                default:
                    ResultView.wrongAnswer();
            }
        }
    }
}
