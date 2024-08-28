package com.thousand.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDTO {

    private Long id;
    private LocalDate date;
    private String address;
    private String city;
    private String state;
    private String Country;
    private Long pinCode;

    private Long customerId;
}

