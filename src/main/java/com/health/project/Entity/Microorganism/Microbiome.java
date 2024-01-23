package com.health.project.Entity.Microorganism;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.health.project.Entity.Microorganism.Microorganism;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Microbiome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "microbiome_no")
    private Long no;

    private String name;



    private String explanation;

    @OneToMany(mappedBy = "microbiome")
    private List<Microorganism> microorganismList = new ArrayList<>();
}
