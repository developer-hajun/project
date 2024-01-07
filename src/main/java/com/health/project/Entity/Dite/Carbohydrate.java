package com.health.project.Entity.Dite;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Carbohydrate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carbohydrate_no",nullable = false)
    private Long no;
    private String name;
    private int content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diet_no")
    private Managing_diet diet;
    public void setDiet(Managing_diet diet){
        this.diet = diet;
        diet.getCarbohydrates().add(this);
    }
}
