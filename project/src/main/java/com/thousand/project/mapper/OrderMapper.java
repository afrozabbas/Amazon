package com.thousand.project.mapper;

import com.thousand.project.dto.OrderDTO;
import com.thousand.project.model.Customer;
import com.thousand.project.model.Order;
import com.thousand.project.model.Payment;
import com.thousand.project.model.Shipment;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderDTO orderDTO, Customer customer, Payment payment, Shipment shipment){
        Order order=new Order();
        order.setId(orderDTO.getId());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setPrice(orderDTO.getPrice());
        order.setCustomer(customer);
        order.setPayment(payment);
        order.setShipment(shipment);
        return order;
    }

    public OrderDTO toOrderDTO(Order order){
        return new OrderDTO(
                order.getId(),
                order.getOrderDate(),
                order.getPrice(),
                order.getCustomer().getId(),
                order.getPayment().getId(),
                order.getShipment().getId()
        );
    }
}
