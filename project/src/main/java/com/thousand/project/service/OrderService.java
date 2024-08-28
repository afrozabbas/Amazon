package com.thousand.project.service;

import com.thousand.project.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO register(OrderDTO orderDTO);

    OrderDTO getById(Long orderId);

    List<OrderDTO> getAll();

    OrderDTO update(OrderDTO orderDTO);

    void deleteById(Long orderId);
}
