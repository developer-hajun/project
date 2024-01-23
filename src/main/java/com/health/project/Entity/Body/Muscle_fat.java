package com.health.project.Entity.Body;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Muscle_fat {
    private float muscle;
    private float weight;
    private float body_fat;

    public Muscle_fat(float muscle, float weight, float body_fat) {
        this.muscle = muscle;
        this.weight = weight;
        this.body_fat = body_fat;
    }
}
