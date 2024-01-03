package com.health.project.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Microbiome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "microbiome_no")
    private Long no;

    private String name;

    @Enumerated(EnumType.STRING)
    private Hazard hazard;

    private String explanation;
}
