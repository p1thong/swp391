package com.p1thong.springsecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "kois")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Koi {

    @Id
    @Column(name = "koiId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long koiId;

    @ManyToOne
    @JoinColumn(name = "pondId")
    private Pond pond;

    @Column(name = "koiName", nullable = false)
    private String koiName;

    @Lob
    @Column(name = "koiImage")
    private byte[] koiImage;

    @Column(name = "size")
    private float size;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "weight")
    private float weight;

    @Column(name = "type")
    private String type;

    @Column(name = "origin")
    private String origin;

    @Column(name = "createDate")
    private LocalDate createDate;

    @OneToMany(mappedBy = "koi", cascade = CascadeType.ALL)
    private List<KoiGrowthLog> koiGrowthLogs;

    // Getters and setters
}

