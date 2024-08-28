package com.thousand.project.service;

import com.thousand.project.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO register(ItemDTO itemDTO);

    ItemDTO getById(Long itemId);

    List<ItemDTO> getAll();

    ItemDTO update(ItemDTO itemDTO);

    void deleteById(Long itemId);
}
