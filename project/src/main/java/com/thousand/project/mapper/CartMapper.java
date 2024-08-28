package com.thousand.project.mapper;

import com.thousand.project.dto.CartDTO;
import com.thousand.project.model.Cart;
import com.thousand.project.model.Customer;
import com.thousand.project.model.Product;
import org.springframework.stereotype.Service;

@Service
public class CartMapper {

    public Cart toCart(CartDTO cartDTO, Customer customer, Product product){
        Cart cart=new Cart();
        cart.setId(cartDTO.getId());
        cart.setQuantity(cartDTO.getQuantity());
        cart.setCustomer(customer);
        cart.setProduct(product);
        return cart;
    }

    public CartDTO toCartDTO(Cart cart){
        return new CartDTO(cart.getId(), cart.getQuantity(),
                cart.getCustomer().getId(),
                cart.getProduct().getId());
    }
}
