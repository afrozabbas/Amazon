package com.thousand.project.mapper;

import com.thousand.project.dto.CategoryDTO;
import com.thousand.project.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    public Category toCategory(CategoryDTO categoryDTO){
        Category category=new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
    }

    public CategoryDTO toCategoryDTO(Category category){
        return new CategoryDTO(
                category.getId(),
                category.getName()
        );
    }
}
