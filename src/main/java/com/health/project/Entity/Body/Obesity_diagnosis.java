package com.health.project.Entity.Body;

import com.health.project.DTO.JoinDTO.Inbody.Obesity_diagnosis_Join_Dto;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Obesity_diagnosis {
    private float BMI;
    private float fat_percentage;
    private float abdominal_fat;
    public Obesity_diagnosis(Obesity_diagnosis_Join_Dto diagnosisJoinDto) {
        this.BMI = diagnosisJoinDto.getBMI();
        this.fat_percentage = diagnosisJoinDto.getFat_percentage();
        this.abdominal_fat = diagnosisJoinDto.getAbdominal_fat();
    }
}
