package com.thousand.project.controller;

import com.thousand.project.dto.ProductDTO;
import com.thousand.project.service.ProductService;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product/")
public class ProductController {

    private final ProductService productService;

    @PostMapping("register")
    public ResponseEntity<ProductDTO> register(@RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.OK).body(productService.register(productDTO));
    }

    @GetMapping("getById/{productId}")
    public ResponseEntity<ProductDTO> getById(@PathVariable("productId") Long productId){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(productId));
    }

    @GetMapping("getAllProducts")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("update")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(productDTO));
    }

    @DeleteMapping("deleteById/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable("productId") Long productId){
        productService.deleteById(productId);
       return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
