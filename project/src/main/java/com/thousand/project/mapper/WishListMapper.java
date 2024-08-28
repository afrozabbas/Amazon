package com.thousand.project.mapper;

import com.thousand.project.dto.WishListDTO;
import com.thousand.project.model.Customer;
import com.thousand.project.model.Product;
import com.thousand.project.model.WishList;
import org.springframework.stereotype.Service;

@Service
public class WishListMapper {
    public WishList toWishList(WishListDTO wishListDTO, Customer customer, Product product){
        WishList wishList=new WishList();
        wishList.setId(wishList.getId());
        wishList.setCustomer(customer);
        wishList.setProduct(product);
        return wishList;
    }

    public WishListDTO toWishListDTO(WishList wishList){
        return new WishListDTO(
                wishList.getId(),
                wishList.getCustomer().getId(),
                wishList.getProduct().getId()
        );
    }
}
