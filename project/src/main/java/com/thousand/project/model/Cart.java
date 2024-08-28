package com.thousand.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name="customerId")
    private Customer customer;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;
}
