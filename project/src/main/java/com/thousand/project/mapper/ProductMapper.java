package com.thousand.project.mapper;

import com.thousand.project.dto.ProductDTO;
import com.thousand.project.model.Category;
import com.thousand.project.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductDTO productDTO, Category category){
        Product product=new Product();
        product.setId(productDTO.getId());
        product.setSku(productDTO.getSku());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setCategory(category);
        return product;
    }

    public ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getSku(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory().getId()
        );
    }
}
