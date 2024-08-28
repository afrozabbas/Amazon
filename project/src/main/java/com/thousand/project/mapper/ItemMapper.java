package com.thousand.project.mapper;

import com.thousand.project.dto.ItemDTO;
import com.thousand.project.model.Item;
import com.thousand.project.model.Order;
import com.thousand.project.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper {
    public Item toItem(ItemDTO itemDTO, Order order, Product product){
        Item item=new Item();
        item.setId(itemDTO.getId());
        item.setQuantity(itemDTO.getQuantity());
        item.setPrice(itemDTO.getPrice());
        item.setOrder(order);
        item.setProduct(product);
        return item;
    }

    public ItemDTO toItemDTO(Item item){
        return new ItemDTO(
                item.getId(),
                item.getQuantity(),
                item.getPrice(),
                item.getOrder().getId(),
                item.getProduct().getId()
                );
    }
}
