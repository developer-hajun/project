package com.health.project.Entity.Body;

import jakarta.persistence.Embeddable;

@Embeddable
public class Obesity_diagnosis {
    private float BMI;
    private float fat_percentage;
    private float abdominal_fat;
}