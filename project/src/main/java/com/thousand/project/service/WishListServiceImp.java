package com.thousand.project.service;

import com.thousand.project.dto.WishListDTO;
import com.thousand.project.exception.CustomerNotFoundException;
import com.thousand.project.exception.ProductNotFoundException;
import com.thousand.project.exception.WishListNotFoundException;
import com.thousand.project.mapper.WishListMapper;
import com.thousand.project.model.Customer;
import com.thousand.project.model.Product;
import com.thousand.project.model.WishList;
import com.thousand.project.repo.CustomerRepo;
import com.thousand.project.repo.ProductRepo;
import com.thousand.project.repo.WishListRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishListServiceImp implements WishListService {

    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final WishListRepo wishListRepo;
    private final WishListMapper wishListMapper;

    @Override
    public WishListDTO register(WishListDTO wishListDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(wishListDTO.getCustomerId());
        Optional<Product> optionalProduct = productRepo.findById(wishListDTO.getProductId());
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with Id:" + wishListDTO.getCustomerId());
        }
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found with Id:" + wishListDTO.getProductId());
        }
        Customer customer = optionalCustomer.get();
        Product product = optionalProduct.get();
        WishList wishList = wishListMapper.toWishList(wishListDTO, customer, product);
        return wishListMapper.toWishListDTO(wishListRepo.save(wishList));
    }

    @Override
    public WishListDTO getById(Long wishListId) {
        Optional<WishList> optionalWishList = wishListRepo.findById(wishListId);
        if (optionalWishList.isEmpty()) {
            throw new WishListNotFoundException("WishList not found with Id:" + wishListId);
        }
        return wishListMapper.toWishListDTO(optionalWishList.get());
    }

    @Override
    public List<WishListDTO> getAll() {
        List<WishList> wishLists = wishListRepo.findAll();
        List<WishListDTO> wishListDTOS = new ArrayList<>();
        for (WishList wishList : wishLists) {
            WishListDTO wishListDTO = wishListMapper.toWishListDTO(wishList);
            wishListDTOS.add(wishListDTO);
        }
        return wishListDTOS;
    }

    @Override
    public WishListDTO update(WishListDTO wishListDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(wishListDTO.getCustomerId());
        Optional<Product> optionalProduct = productRepo.findById(wishListDTO.getProductId());
        Optional<WishList> optionalWishList = wishListRepo.findById(wishListDTO.getId());
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with Id:" + wishListDTO.getCustomerId());
        }
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found with Id:" + wishListDTO.getProductId());
        }
        if (optionalWishList.isEmpty()) {
            throw new WishListNotFoundException("WishList not found with Id:" + wishListDTO.getId());
        }
        Customer customer = optionalCustomer.get();
        Product product = optionalProduct.get();
        WishList wishList = wishListMapper.toWishList(wishListDTO, customer, product);
        return wishListMapper.toWishListDTO(wishListRepo.save(wishList));
    }

    @Override
    public void deleteById(Long wishListId) {
        Optional<WishList> optionalWishList = wishListRepo.findById(wishListId);
        if (optionalWishList.isEmpty()) {
            throw new WishListNotFoundException("WishList not found with Id:" + wishListId);
        }
        wishListRepo.deleteById(wishListId);
    }
}
