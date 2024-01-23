package com.health.project.DTO.JoinDTO.Inbody;

import lombok.Data;

@Data
public class Obesity_diagnosis_Join_Dto {
    private float BMI;
    private float fat_percentage;
    private float abdominal_fat;

    public Obesity_diagnosis_Join_Dto(float BMI, float fat_percentage, float abdominal_fat) {
        this.BMI = BMI;
        this.fat_percentage = fat_percentage;
        this.abdominal_fat = abdominal_fat;
    }
}
