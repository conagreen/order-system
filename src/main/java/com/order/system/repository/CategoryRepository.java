package com.order.system.repository;

import com.order.system.domain.Category;

import java.util.List;

public interface CategoryRepository {
    void init();

    List<Category> getCategories();
}
