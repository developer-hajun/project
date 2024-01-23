package com.health.project.DTO.JoinDTO.Inbody;

import lombok.Data;

@Data
public class Muscle_fat_Join_Dto {
    private float muscle;
    private float weight;
    private float body_fat;

    public Muscle_fat_Join_Dto(float muscle, float weight, float body_fat) {
        this.muscle = muscle;
        this.weight = weight;
        this.body_fat = body_fat;
    }
}
