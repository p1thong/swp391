package com.p1thong.springsecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "waterParams")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WaterParam {

    @Id
    @Column(name = "waterParamId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long waterParamId;

    @ManyToOne
    @JoinColumn(name = "pondId")
    private Pond pond;

    @Column(name = "O2")
    private float o2;

    @Column(name = "temperature")
    private float temperature;

    @Column(name = "NH4")
    private float nh4;

    @Column(name = "salt")
    private float salt;

    @Column(name = "pH")
    private float ph;

    @Column(name = "NO2")
    private float no2;

    @Column(name = "NO3")
    private float no3;

    @Column(name = "createDate")
    private LocalDate createDate;

    // Getters and setters
}

