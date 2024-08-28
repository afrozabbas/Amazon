package com.thousand.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    private Long quantity;
    private Double price;
    private Long orderId;
    private Long productId;
}
