package com.thousand.project.service;

import com.thousand.project.dto.ProductDTO;
import com.thousand.project.exception.CategoryNotFoundException;
import com.thousand.project.exception.ProductNotFoundException;
import com.thousand.project.mapper.ProductMapper;
import com.thousand.project.model.Category;
import com.thousand.project.model.Product;
import com.thousand.project.repo.CategoryRepo;
import com.thousand.project.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO register(ProductDTO productDTO) {
       Optional<Category> optionalCategory= categoryRepo.findById(productDTO.getCategoryId());
        if (optionalCategory.isEmpty()){
            throw new CategoryNotFoundException("Category not found with Id:" + productDTO.getCategoryId());
        }
        Category category=optionalCategory.get();
        Product product=productMapper.toProduct(productDTO,category);
        return productMapper.toProductDTO(productRepo.save(product));
    }

    @Override
    public ProductDTO getById(Long productId) {
      Optional<Product> optionalProduct= productRepo.findById(productId);
      if(optionalProduct.isEmpty()){
          throw new ProductNotFoundException("Product not found with Id:" + productId);

      }
        return productMapper.toProductDTO(optionalProduct.get());
    }

    @Override
    public List<ProductDTO> getAllProducts() {
      List<Product> products=  productRepo.findAll();
      List<ProductDTO> productDTOS=new ArrayList<>();
      for(Product product:products){
          ProductDTO productDTO=productMapper.toProductDTO(product);
          productDTOS.add(productDTO);
      }
        return productDTOS;
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
       Optional<Category> optionalCategory= categoryRepo.findById(productDTO.getCategoryId());
      Optional<Product> optionalProduct= productRepo.findById(productDTO.getId());
      if(optionalCategory.isEmpty()){
          throw new CategoryNotFoundException("Category not found with Id:" + productDTO.getCategoryId());
      }
      if (optionalProduct.isEmpty()){
          throw new ProductNotFoundException("Product not found with Id:" + productDTO.getId());
      }
      Category category=optionalCategory.get();
      Product product=productMapper.toProduct(productDTO,category);
        return productMapper.toProductDTO(productRepo.save(product));
    }

    @Override
    public void deleteById(Long productId) {
     Optional<Product> optionalProduct=productRepo.findById(productId);
     if(optionalProduct.isEmpty()){
         throw new ProductNotFoundException("Product not found with Id:" + productId);
     }
     productRepo.deleteById(productId);
    }
}
