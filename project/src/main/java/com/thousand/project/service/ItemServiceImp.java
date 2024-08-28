package com.thousand.project.service;

import com.thousand.project.dto.ItemDTO;
import com.thousand.project.exception.ItemNotFoundException;
import com.thousand.project.exception.OrderNotFoundException;
import com.thousand.project.exception.ProductNotFoundException;
import com.thousand.project.mapper.ItemMapper;
import com.thousand.project.model.Item;
import com.thousand.project.model.Order;
import com.thousand.project.model.Product;
import com.thousand.project.repo.ItemRepo;
import com.thousand.project.repo.OrderRepo;
import com.thousand.project.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImp implements ItemService {

    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    private final ItemMapper itemMapper;
    private final ItemRepo itemRepo;


    @Override
    public ItemDTO register(ItemDTO itemDTO) {
        Optional<Order> optionalOrder = orderRepo.findById(itemDTO.getOrderId());
        Optional<Product> optionalProduct = productRepo.findById(itemDTO.getProductId());
        if (optionalOrder.isEmpty()) {
            throw new OrderNotFoundException("Order not found with Id:" + itemDTO.getId());
        }
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("product not found with Id:" + itemDTO.getId());
        }
        Order order = optionalOrder.get();
        Product product = optionalProduct.get();
        Item item = itemMapper.toItem(itemDTO, order, product);
        return itemMapper.toItemDTO(itemRepo.save(item));
    }

    @Override
    public ItemDTO getById(Long itemId) {
        Optional<Item> optionalItem = itemRepo.findById(itemId);
        if (optionalItem.isEmpty()) {
            throw new ItemNotFoundException("Item not found with Id:" + itemId);
        }

        return itemMapper.toItemDTO(optionalItem.get());
    }

    @Override
    public List<ItemDTO> getAll() {
        List<Item> items = itemRepo.findAll();
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : items) {
            ItemDTO itemDTO = itemMapper.toItemDTO(item);
            itemDTOS.add(itemDTO);
        }
        return itemDTOS;
    }

    @Override
    public ItemDTO update(ItemDTO itemDTO) {
        Optional<Order> optionalOrder = orderRepo.findById(itemDTO.getOrderId());
        Optional<Product> optionalProduct = productRepo.findById(itemDTO.getProductId());
        Optional<Item> optionalItem = itemRepo.findById(itemDTO.getId());
        if (optionalOrder.isEmpty()) {
            throw new OrderNotFoundException("Order not found with Id:" + itemDTO.getId());
        }
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("product not found with Id:" + itemDTO.getId());
        }
        if (optionalItem.isEmpty()) {
            throw new ItemNotFoundException("Item not found with Id:" + itemDTO.getId());
        }
        Order order = optionalOrder.get();
        Product product = optionalProduct.get();
        Item item = itemMapper.toItem(itemDTO, order, product);
        return itemMapper.toItemDTO(itemRepo.save(item));
    }

    @Override
    public void deleteById(Long itemId) {
        Optional<Item> optionalItem = itemRepo.findById(itemId);
        if (optionalItem.isEmpty()) {
            throw new ItemNotFoundException("Item not found with Id:" + itemId);
        }
        itemRepo.deleteById(itemId);
    }
}
