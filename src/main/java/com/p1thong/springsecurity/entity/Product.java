package com.p1thong.springsecurity.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "productId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "cateId")
    private Category category;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "unitPrice", nullable = false)
    private float unitPrice;

    @Column(name = "stock")
    private int stock;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;


    // Getters and setters
}

