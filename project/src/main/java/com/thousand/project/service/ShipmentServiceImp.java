package com.thousand.project.service;

import com.thousand.project.dto.ShipmentDTO;
import com.thousand.project.exception.CustomerNotFoundException;
import com.thousand.project.exception.ShipmentNotFoundException;
import com.thousand.project.mapper.ShipmentMapper;
import com.thousand.project.model.Customer;
import com.thousand.project.model.Shipment;
import com.thousand.project.repo.CustomerRepo;
import com.thousand.project.repo.ShipmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImp implements ShipmentService {
    private final CustomerRepo customerRepo;
    private final ShipmentMapper shipmentMapper;
    private final ShipmentRepo shipmentRepo;

    @Override
    public ShipmentDTO register(ShipmentDTO shipmentDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(shipmentDTO.getCustomerId());
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with Id:" + shipmentDTO.getCustomerId());
        }
        Customer customer = optionalCustomer.get();
        Shipment shipment = shipmentMapper.toShipment(shipmentDTO, customer);
        return shipmentMapper.toShipmentDTO(shipmentRepo.save(shipment));
    }

    @Override
    public ShipmentDTO getById(Long shipmentId) {
        Optional<Shipment> optionalShipment = shipmentRepo.findById(shipmentId);
        if (optionalShipment.isEmpty()) {
            throw new ShipmentNotFoundException("Shipment not found with Id:" + shipmentId);

        }
        return shipmentMapper.toShipmentDTO(optionalShipment.get());
    }

    @Override
    public List<ShipmentDTO> getAllShipments() {
        List<Shipment> shipments = shipmentRepo.findAll();
        List<ShipmentDTO> shipmentDTOS = new ArrayList<>();
        for (Shipment shipment : shipments) {
            ShipmentDTO shipmentDTO = shipmentMapper.toShipmentDTO(shipment);
            shipmentDTOS.add(shipmentDTO);
        }
        return shipmentDTOS;
    }

    @Override
    public ShipmentDTO update(ShipmentDTO shipmentDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(shipmentDTO.getCustomerId());
        Optional<Shipment> optionalShipment = shipmentRepo.findById(shipmentDTO.getId());
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with Id:" + shipmentDTO.getCustomerId());
        }
        if (optionalShipment.isEmpty()) {
            throw new ShipmentNotFoundException("Shipment not found with Id:" + shipmentDTO.getId());
        }
        Customer customer = optionalCustomer.get();
        Shipment shipment = shipmentMapper.toShipment(shipmentDTO, customer);
        return shipmentMapper.toShipmentDTO(shipmentRepo.save(shipment));
    }

    @Override
    public void deleteById(Long shipmentId) {
        Optional<Shipment> optionalShipment = shipmentRepo.findById(shipmentId);
        if (optionalShipment.isEmpty()) {
            throw new ShipmentNotFoundException("Shipment not found with Id:" + shipmentId);
        }
        shipmentRepo.deleteById(shipmentId);
    }


}
