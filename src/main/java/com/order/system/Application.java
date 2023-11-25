package com.order.system;

import java.math.BigDecimal;
import java.util.*;

public class Application {
    Map<String, String> categories;
    Map<Long, Item> items;

    public Application() {
        categories = new HashMap<>();
        categories.put("1", "의류");
        categories.put("2", "가방");
        categories.put("3", "신발");

        items = new HashMap<>();
        items.put(1L, new Item(1L, "나이키 상의", BigDecimal.valueOf(48000), 1, 5L));
        items.put(2L, new Item(2L, "아디다스 상의", BigDecimal.valueOf(38000), 1, 10L));

        items.put(3L, new Item(3L, "나이키 가방", BigDecimal.valueOf(98000), 2, 7L));
        items.put(4L, new Item(4L, "아디다스 가방", BigDecimal.valueOf(62000), 2, 7L));
        items.put(5L, new Item(5L, "루이비통 가방", BigDecimal.valueOf(4200000), 2, 3L));

        items.put(6L, new Item(6L, "나이키 신발", BigDecimal.valueOf(92000), 3, 10L));
        items.put(7L, new Item(7L, "아디다스 신발", BigDecimal.valueOf(120000), 3, 15L));
        items.put(8L, new Item(8L, "뉴발란스 신발", BigDecimal.valueOf(128000), 3, 30L));
        items.put(9L, new Item(9L, "크록스 신발", BigDecimal.valueOf(42000), 3, 20L));
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.process();
    }

    private void process() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("주문하시겠습니까? (o: 주문, q: 종료)");
        String answer = scanner.nextLine();

        switch (answer) {
            case "o" :
                long categoryId = selectItemCategory();
                selectItem(categoryId);
                break;
            case "q" :
                System.out.println("주문을 종료합니다. 감사합니다.");
                break;
            default :
                System.out.println("올바른 값을 입력하십시오.");
                process();

        }
    }

    private void selectItem(long categoryId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("상품번호 / 상품명 / 가격 / 재고수량");

        for (Map.Entry<Long, Item> itemMap : items.entrySet()) {
            Item item = itemMap.getValue();
            if (item.getCategoryId() == categoryId) {
                System.out.println(item.getId() + " " + item.getName() + " " + item.getPrice() + " " + item.getQuantity());
            }
        }

        System.out.println("상품 번호를 입력하십시오. (q: 종료)");
        long itemId = scanner.nextInt();
        System.out.println("구매 수량을 입력하십시오. (q: 종료)");
        long quantity = scanner.nextInt();

        Item item = items.get(itemId);
        System.out.println("< 구매 목록 >");
        System.out.println(item.getId() + " " + item.getName() + " " + item.getPrice());
        System.out.println("수량: "  + quantity);

    }

    private long selectItemCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("카테고리 번호를 입력하십시오. (q: 종료)");
        for (Map.Entry<String, String> category : categories.entrySet()) {
            System.out.println(category.getKey() + ". " + category.getValue());
        }

        return scanner.nextInt();
    }
}
