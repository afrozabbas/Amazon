package com.thousand.project.service;

import com.thousand.project.dto.CategoryDTO;
import com.thousand.project.exception.CategoryNotFoundException;
import com.thousand.project.mapper.CategoryMapper;
import com.thousand.project.model.Category;
import com.thousand.project.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDTO register(CategoryDTO categoryDTO) {
        return categoryMapper.toCategoryDTO(categoryRepo.save(categoryMapper.toCategory(categoryDTO)));
    }

    @Override
    public CategoryDTO getById(Long categoryId) {
        Optional<Category> optionalCategory = categoryRepo.findById(categoryId);
        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Category not found with Id:" + categoryId);

        }
        return categoryMapper.toCategoryDTO(optionalCategory.get());
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO categoryDTO = categoryMapper.toCategoryDTO(category);
            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
      Optional<Category> optionalCategory=categoryRepo.findById(categoryDTO.getId());
      if (optionalCategory.isEmpty()){
          throw new CategoryNotFoundException("Category not found with Id:" + categoryDTO.getId());
      }
        return categoryMapper.toCategoryDTO(categoryMapper.toCategory(categoryDTO));
    }

    @Override
    public void deleteById(Long categoryId) {
        Optional<Category> optionalCategory = categoryRepo.findById(categoryId);
        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Category not found with Id:" + categoryId);
        }
        categoryRepo.deleteById(categoryId);
    }
}
