package com.p1thong.springsecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "blogs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @Column(name = "blogId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "createDate")
    private LocalDate createDate;

    // Getters and setters
}
