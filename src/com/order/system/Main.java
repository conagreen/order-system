package com.order.system;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    Map<String , String> categories;

    public Main() {
        categories = new HashMap<>();
        categories.put("1", "의류");
        categories.put("2", "가방");
        categories.put("3", "신발");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.process();
    }

    private void process() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("주문하시겠습니까? (o: 주문, q: 종료)");
        String answer = scanner.nextLine();

        switch (answer) {
            case "o" -> {
                String categoryId = selectItemCategory();
            }
            case "q" -> System.out.println("주문을 종료합니다. 감사합니다.");
            default -> {
                System.out.println("올바른 값을 입력하십시오.");
                process();
            }
        }
    }

    private String selectItemCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("카테고리 번호를 입력하십시오. (q: 종료)");
        for (Map.Entry<String, String> category : categories.entrySet()) {
            System.out.println(category.getKey() + ". " + category.getValue());
        }

        return scanner.nextLine();
    }
}
