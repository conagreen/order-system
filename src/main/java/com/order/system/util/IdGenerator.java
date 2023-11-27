package com.order.system.util;

public class IdGenerator {
    private static int orderId;
    
    public static int orderId() {
        return orderId++;
    } 
}
