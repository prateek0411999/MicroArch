package com.programming.techie.orderservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order_line_items")
@Data

public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
