package com.thousand.project.controller;

import com.thousand.project.dto.ShipmentDTO;
import com.thousand.project.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;


    @PostMapping("register")
    public ResponseEntity<ShipmentDTO> register(@RequestBody ShipmentDTO shipmentDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(shipmentService.register(shipmentDTO));
    }

    @GetMapping("getById/{shipmentId}")
    public ResponseEntity<ShipmentDTO> getById(@PathVariable("shipmentId") Long shipmentId) {
        return ResponseEntity.status(HttpStatus.OK).body(shipmentService.getById(shipmentId));
    }

    @GetMapping("getAllShipments")
    public List<ShipmentDTO> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @PutMapping("update")
    public ResponseEntity<ShipmentDTO> update(@RequestBody ShipmentDTO shipmentDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(shipmentService.update(shipmentDTO));
    }

    @DeleteMapping("deleteById/{shipmentId}")
    public ResponseEntity<String> deleteById(@PathVariable("shipmentId") Long shipmentId) {
        shipmentService.deleteById(shipmentId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
