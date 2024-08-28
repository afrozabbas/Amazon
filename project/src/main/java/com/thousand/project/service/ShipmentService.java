package com.thousand.project.service;

import com.thousand.project.dto.ShipmentDTO;

import java.util.List;

public interface ShipmentService {
    ShipmentDTO register(ShipmentDTO shipmentDTO);

    ShipmentDTO getById(Long shipmentId);

    List<ShipmentDTO> getAllShipments();

    ShipmentDTO update(ShipmentDTO shipmentDTO);

    void deleteById(Long shipmentId);
}
