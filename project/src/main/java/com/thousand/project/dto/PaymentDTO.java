package com.thousand.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private String transactionNumber;
    private LocalDateTime paymentDate;
    private String paymentMethod;
    private Double amount;

    private Long customerId;

}
