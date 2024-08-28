package com.thousand.project.mapper;

import com.thousand.project.dto.ShipmentDTO;
import com.thousand.project.model.Customer;
import com.thousand.project.model.Shipment;
import org.springframework.stereotype.Service;

@Service
public class ShipmentMapper {

    public Shipment toShipment(ShipmentDTO shipmentDTO, Customer customer){
        Shipment shipment=new Shipment();
        shipment.setId(shipmentDTO.getId());
        shipment.setDate(shipmentDTO.getDate());
        shipment.setAddress(shipmentDTO.getAddress());
        shipment.setCity(shipmentDTO.getCity());
        shipment.setState(shipmentDTO.getState());
        shipment.setCountry(shipmentDTO.getCountry());
        shipment.setPinCode(shipmentDTO.getPinCode());
        shipment.setCustomer(customer);
        return shipment;
    }

    public ShipmentDTO toShipmentDTO(Shipment shipment){
      return  new ShipmentDTO  (shipment.getId(),
        shipment.getDate(),
        shipment.getAddress(),
        shipment.getCity(),
        shipment.getState(),
        shipment.getCountry(),
        shipment.getPinCode(),
        shipment.getCustomer().getId());
    }
}
