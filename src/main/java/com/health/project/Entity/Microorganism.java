package com.health.project.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Microorganism {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "microorganism_no")
    private Long no;

    private String name;
    private double shame;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "microbiome_no")
    private Microbiome microbiome;
}
