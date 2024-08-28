package com.thousand.project.service;

import com.thousand.project.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO register(CategoryDTO categoryDTO);

    CategoryDTO getById(Long categoryId);

    List<CategoryDTO> getAllCategories();

    CategoryDTO update(CategoryDTO categoryDTO);

    void deleteById(Long categoryId);
}
