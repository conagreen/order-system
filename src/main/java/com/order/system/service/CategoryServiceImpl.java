package com.order.system.service;

import com.order.system.repository.CategoryListRepository;
import com.order.system.repository.CategoryRepository;
import com.order.system.view.InputView;

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository = new CategoryListRepository();

    @Override
    public long getSelectedCategoryId() {
        return InputView.categoryId(categoryRepository.getCategories());
    }
}
