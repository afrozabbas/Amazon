package com.thousand.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CustomerOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderDate;
    private Double price;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentId")
    private Payment payment;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Item> items=new ArrayList<>();

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "shipmentIdz")
    private Shipment shipment;


}
