package com.order.system.service;

import com.order.system.domain.strategy.OrderStandardStrategy;
import com.order.system.exception.SoldOutException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderServiceImplTest {
    Map<Long, Integer> menuCard;
    OrderService orderService;

    void init() {
        menuCard = new HashMap<>();
        menuCard.put(1L, 5);
        orderService = new OrderServiceImpl(
                new CategoryServiceImpl(), new ItemServiceImpl(), new OrderStandardStrategy(), menuCard);
    }

    @Test
    @DisplayName(value = "멀티 스레드 환경에서의 재고 검증 테스트 - SoldOutException 발생")
    public void 멀티_스레드_환경에서의_재고_검증() {
        init();
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        assertThrows(SoldOutException.class, thread2::run);
    }

    public class MyThread extends Thread {
        public void run() {
            orderService.order(menuCard);
        }
    }
}