package com.p1thong.springsecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "cateId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cateId;

    @Column(name = "cateName", nullable = false)
    private String cateName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    // Getters and setters
}
