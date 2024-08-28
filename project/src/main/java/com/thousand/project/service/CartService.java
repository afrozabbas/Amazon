package com.thousand.project.service;

import com.thousand.project.dto.CartDTO;

import java.util.List;

public interface CartService {
    CartDTO register(CartDTO cartDTO);

    CartDTO getById(Long cartId);

    List<CartDTO> getAll();

    CartDTO update(CartDTO cartDTO);

    void deleteById(Long cartId);
}
