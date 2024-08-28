package com.thousand.project.service;

import com.thousand.project.dto.OrderDTO;
import com.thousand.project.exception.CustomerNotFoundException;
import com.thousand.project.exception.OrderNotFoundException;
import com.thousand.project.exception.PaymentNotFoundException;
import com.thousand.project.exception.ShipmentNotFoundException;
import com.thousand.project.mapper.OrderMapper;
import com.thousand.project.model.Customer;
import com.thousand.project.model.Order;
import com.thousand.project.model.Payment;
import com.thousand.project.model.Shipment;
import com.thousand.project.repo.CustomerRepo;
import com.thousand.project.repo.OrderRepo;
import com.thousand.project.repo.PaymentRepo;
import com.thousand.project.repo.ShipmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class OrderServiceImp implements OrderService {

    private final CustomerRepo customerRepo;
    private final PaymentRepo paymentRepo;
    private final ShipmentRepo shipmentRepo;
    private final OrderMapper orderMapper;
    private final OrderRepo orderRepo;

    @Override
    public OrderDTO register(OrderDTO orderDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(orderDTO.getCustomerId());
        Optional<Payment> optionalPayment = paymentRepo.findById(orderDTO.getPaymentId());
        Optional<Shipment> optionalShipment = shipmentRepo.findById(orderDTO.getShipmentId());
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with Id:" + orderDTO.getCustomerId());
        }
        if (optionalPayment.isEmpty()) {
            throw new PaymentNotFoundException("Payment not found with Id:" + orderDTO.getPaymentId());
        }
        if (optionalShipment.isEmpty()) {
            throw new ShipmentNotFoundException("Shipment not found with Id:" + orderDTO.getShipmentId());
        }
        Customer customer = optionalCustomer.get();
        Payment payment = optionalPayment.get();
        Shipment shipment = optionalShipment.get();
        Order order = orderMapper.toOrder(orderDTO, customer, payment, shipment);
        return orderMapper.toOrderDTO(orderRepo.save(order));
    }

    @Override
    public OrderDTO getById(Long orderId) {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new OrderNotFoundException("Order not found with Id:" + orderId);
        }
        return orderMapper.toOrderDTO(optionalOrder.get());
    }

    @Override
    public List<OrderDTO> getAll() {
        List<Order> orders = orderRepo.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = orderMapper.toOrderDTO(order);
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(orderDTO.getCustomerId());
        Optional<Payment> optionalPayment = paymentRepo.findById(orderDTO.getPaymentId());
        Optional<Shipment> optionalShipment = shipmentRepo.findById(orderDTO.getShipmentId());
        Optional<Order> optionalOrder = orderRepo.findById(orderDTO.getId());
        if (optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer not found with Id:" + orderDTO.getCustomerId());
        }
        if (optionalPayment.isEmpty()){
            throw new PaymentNotFoundException("Payment not found with Id:" + orderDTO.getPaymentId());
        }
        if (optionalShipment.isEmpty()){
            throw new ShipmentNotFoundException("Shipment not found with Id:" + orderDTO.getShipmentId());
        }
        if (optionalOrder.isEmpty()){
            throw new OrderNotFoundException("Order not found with Id:" + orderDTO.getId());
        }
        Customer customer=optionalCustomer.get();
        Payment payment=optionalPayment.get();
        Shipment shipment=optionalShipment.get();
        Order order=orderMapper.toOrder(orderDTO,customer,payment,shipment);
        return orderMapper.toOrderDTO(orderRepo.save(order));
    }

    @Override
    public void deleteById(Long orderId) {
      Optional<Order> optionalOrder= orderRepo.findById(orderId);
      if (optionalOrder.isEmpty()){
          throw new OrderNotFoundException("Order not found with Id:" + orderId);
      }
      orderRepo.deleteById(orderId);
    }
}
