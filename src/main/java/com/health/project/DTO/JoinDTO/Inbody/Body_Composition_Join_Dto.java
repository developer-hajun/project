package com.health.project.DTO.JoinDTO.Inbody;

import lombok.Data;

@Data
public class Body_Composition_Join_Dto {
    private float water;
    private float protein;
    private float mineral;
    private float fat;

    public Body_Composition_Join_Dto(float water, float protein, float mineral, float fat) {
        this.water = water;
        this.protein = protein;
        this.mineral = mineral;
        this.fat = fat;
    }
}
