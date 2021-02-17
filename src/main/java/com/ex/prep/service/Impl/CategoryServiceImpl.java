package com.ex.prep.service.Impl;

import com.ex.prep.model.entities.CategoryEntity;
import com.ex.prep.model.entities.enums.CategoryNameEnum;
import com.ex.prep.repository.CategoryRepository;
import com.ex.prep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        CategoryEntity category = new CategoryEntity(categoryNameEnum,
                                "Description for " + categoryNameEnum.name());
                        categoryRepository.save(category);
                    });
        }
    }
}
