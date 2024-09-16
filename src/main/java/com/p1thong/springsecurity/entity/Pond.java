package com.p1thong.springsecurity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ponds")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pond {

    @Id
    @Column(name = "pondId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pondId;


    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "pondName", nullable = false)
    private String pondName;

    @Column(name = "pumpPower")
    private float pumpPower;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "size")
    private float size;

    @Column(name = "depth")
    private float depth;

    @Column(name = "volume")
    private float volume;

    @Column(name = "vein")
    private int vein;

    @Column(name = "createDate")
    private LocalDate createDate;

    @OneToMany(mappedBy = "pond", cascade = CascadeType.ALL)
    private List<Koi> kois;

    @OneToMany(mappedBy = "pond", cascade = CascadeType.ALL)
    private List<WaterParam> waterParams;

}

