package com.thousand.project.service;

import com.thousand.project.dto.WishListDTO;

import java.util.List;

public interface WishListService {
    WishListDTO register(WishListDTO wishListDTO);

    WishListDTO getById(Long wishListId);

    List<WishListDTO> getAll();

    WishListDTO update(WishListDTO wishListDTO);

    void deleteById(Long wishListId);
}
