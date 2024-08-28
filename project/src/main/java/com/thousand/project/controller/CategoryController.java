package com.thousand.project.controller;


import com.thousand.project.dto.CategoryDTO;
import com.thousand.project.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Category/")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("register")
    public ResponseEntity<CategoryDTO> register(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.register(categoryDTO));
    }

    @GetMapping("getById/{categoryId}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable("categoryId") Long categoryId){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getById(categoryId));
    }

    @GetMapping("getAllCategories")
    public List<CategoryDTO> getAllCategories(){
        return  categoryService.getAllCategories();
    }

    @PutMapping("update")
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(categoryDTO));
    }

    @DeleteMapping("deleteById/{categoryId}")
    public ResponseEntity<String> deleteById(@PathVariable("categoryId") Long categoryId){
         categoryService.deleteById(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
