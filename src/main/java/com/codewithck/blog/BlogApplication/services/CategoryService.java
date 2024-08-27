package com.codewithck.blog.BlogApplication.services;

import com.codewithck.blog.BlogApplication.payload.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);

    void deleteCategory(Integer categoryId);

    CategoryDTO getCategoryById(Integer categoryId);

    List<CategoryDTO> getAllCategories();
}