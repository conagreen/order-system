package com.order.system.repository;

import com.order.system.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryListRepository implements CategoryRepository {
    List<Category> categories;

    public CategoryListRepository() {
        init();
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void init() {
        categories = new ArrayList<>();
        categories.add(new Category(1, "의류"));
        categories.add(new Category(2, "가방"));
        categories.add(new Category(3, "신발"));
    }
}
