package com.thousand.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String sku;
    private String description;
    private Double price;
    private Integer stock;

    private Long categoryId;

}
