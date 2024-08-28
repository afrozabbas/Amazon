package com.thousand.project.service;

import com.thousand.project.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO register(ProductDTO productDTO);

    ProductDTO getById(Long productId);

    List<ProductDTO> getAllProducts();

    ProductDTO update(ProductDTO productDTO);

    void deleteById(Long productId);
}
