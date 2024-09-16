package com.p1thong.springsecurity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "koiGrowthLogs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KoiGrowthLog {

    @Id
    @Column(name = "koiLogId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long koiLogId;

    @ManyToOne
    @JoinColumn(name = "koiId")
    private Koi koi;

    @Column(name = "koiLogDate", nullable = false)
    private LocalDate koiLogDate;

    @Column(name = "weight")
    private float weight;

    @Column(name = "size")
    private float size;

    // Getters and setters
}

