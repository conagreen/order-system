package com.order.system.view;

import com.order.system.domain.Category;
import com.order.system.domain.Item;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static String askingOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("안녕하세요. 주문하시겠습니까? (o: 주문, q: 종료)");
        return scanner.nextLine();
    }

    public static long categoryId(List<Category> categories) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("카테고리 번호를 입력하십시오. (q: 종료)");
        for (Category category : categories) {
            System.out.println(category.getId() + ". " + category.getName());
        }
        return scanner.nextInt();
    }

    public static String itemIdAndQuantity(List<Item> items) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("상품번호 / 상품명 / 가격 / 재고수량");
        for (Item item : items) {
            System.out.printf("%d / %s / %d / %d%n", item.getId(), item.getName(), item.getAmount(), item.getStock());
        }
        System.out.println("상품 번호와 구매 수량을 공백으로 구분하여 입력하십시오. (p: 이전, y: 결제, q: 종료)");
        return scanner.nextLine();
    }
}
