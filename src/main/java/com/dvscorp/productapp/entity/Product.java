package com.dvscorp.productapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String productName;
    @Column
    private String description;
    @Column
    private double price;
    @Column
    private BigInteger quantity;


}
