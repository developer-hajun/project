package com.health.project.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Muscle_fat {
    private float muscle;
    private float weight;
    private float body_fat;
}
