package com.thousand.project.service;

import com.thousand.project.dto.CartDTO;
import com.thousand.project.exception.CartNotFoundException;
import com.thousand.project.exception.CustomerNotFoundException;
import com.thousand.project.exception.ProductNotFoundException;
import com.thousand.project.mapper.CartMapper;
import com.thousand.project.model.Cart;
import com.thousand.project.model.Customer;
import com.thousand.project.model.Product;
import com.thousand.project.repo.CartRepo;
import com.thousand.project.repo.CustomerRepo;
import com.thousand.project.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImp implements CartService{
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final CartMapper cartMapper;
    private final CartRepo cartRepo;


    @Override
    public CartDTO register(CartDTO cartDTO) {
       Optional<Customer> optionalCustomer= customerRepo.findById(cartDTO.getCustomerId());
      Optional<Product>  optionalProduct= productRepo.findById(cartDTO.getProductId());
      if (optionalCustomer.isEmpty()){
          throw new CustomerNotFoundException("Customer not found with Id:" + cartDTO.getCustomerId());
      }
      if (optionalProduct.isEmpty()){
          throw new ProductNotFoundException("Product not found with Id:" + cartDTO.getProductId());
      }
      Customer customer=optionalCustomer.get();
      Product product=optionalProduct.get();
        Cart cart=cartMapper.toCart(cartDTO,customer,product);
        return cartMapper.toCartDTO(cartRepo.save(cart));
    }

    @Override
    public CartDTO getById(Long cartId) {
      Optional<Cart> optionalCart=cartRepo.findById(cartId);
      if(optionalCart.isEmpty()){
          throw new CartNotFoundException("Cart not found with Id:"+cartId);
      }
        return cartMapper.toCartDTO(optionalCart.get());
    }

    @Override
    public List<CartDTO> getAll() {
      List<Cart> carts=cartRepo.findAll();
      List<CartDTO> cartDTOS=new ArrayList<>();
      for(Cart cart:carts){
          CartDTO cartDTO=cartMapper.toCartDTO(cart);
          cartDTOS.add(cartDTO);
      }
        return cartDTOS;
    }

    @Override
    public CartDTO update(CartDTO cartDTO) {
      Optional<Customer> optionalCustomer=customerRepo.findById(cartDTO.getCustomerId());
       Optional<Product> optionalProduct=productRepo.findById(cartDTO.getProductId());
       Optional<Cart> optionalCart=cartRepo.findById(cartDTO.getId());
       if(optionalCustomer.isEmpty()){
           throw new CustomerNotFoundException("Customer not found with Id:" + cartDTO.getCustomerId());
       }
       if(optionalProduct.isEmpty()){
           throw new ProductNotFoundException("Product not found with Id:" + cartDTO.getProductId());
       }
       if(optionalCart.isEmpty()){
           throw new CartNotFoundException("Cart not found with Id:"+cartDTO.getId());
       }
       Customer customer=optionalCustomer.get();
       Product product=optionalProduct.get();
       Cart cart=cartMapper.toCart(cartDTO,customer,product);
       return cartMapper.toCartDTO(cartRepo.save(cart));
    }

    @Override
    public void deleteById(Long cartId) {
      Optional<Cart> optionalCart=cartRepo.findById(cartId);
      if(optionalCart.isEmpty()){
          throw new CartNotFoundException("Cart not found with Id:"+cartId);
      }
      cartRepo.deleteById(cartId);
    }


}
