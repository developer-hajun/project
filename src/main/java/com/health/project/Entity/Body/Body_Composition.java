package com.health.project.Entity.Body;

import com.health.project.DTO.JoinDTO.Inbody.Body_Composition_Join_Dto;
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

    public Body_Composition(Body_Composition_Join_Dto CompositionJoinDto) {
        this.water = CompositionJoinDto.getWater();
        this.protein = CompositionJoinDto.getProtein();
        this.mineral = CompositionJoinDto.getMineral();
        this.fat = CompositionJoinDto.getFat();
    }
}
