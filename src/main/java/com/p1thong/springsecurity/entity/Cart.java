package com.p1thong.springsecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "carts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @Column(name = "cartId", nullable = false)
    private String cartId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "createDate")
    private LocalDate createDate;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    // Getters and setters
}

