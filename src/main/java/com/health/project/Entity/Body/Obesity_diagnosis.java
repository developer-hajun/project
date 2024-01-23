package com.health.project.Entity.Body;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Obesity_diagnosis {
    private float BMI;
    private float fat_percentage;
    private float abdominal_fat;

    public Obesity_diagnosis(float BMI, float fat_percentage, float abdominal_fat) {
        this.BMI = BMI;
        this.fat_percentage = fat_percentage;
        this.abdominal_fat = abdominal_fat;
    }
}
