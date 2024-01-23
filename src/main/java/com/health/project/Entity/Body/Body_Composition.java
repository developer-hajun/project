package com.health.project.Entity.Body;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Body_Composition {
    private float water;
    private float protein;
    private float mineral;
    private float fat;

    public Body_Composition(float water, float protein, float mineral, float fat) {
        this.water = water;
        this.protein = protein;
        this.mineral = mineral;
        this.fat = fat;
    }
}
