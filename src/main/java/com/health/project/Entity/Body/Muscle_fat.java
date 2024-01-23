package com.health.project.Entity.Body;

import com.health.project.DTO.JoinDTO.Inbody.Muscle_fat_Join_Dto;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Muscle_fat {
    private float muscle;
    private float weight;
    private float body_fat;

    public Muscle_fat(Muscle_fat_Join_Dto fatJoinDto) {
        this.muscle = fatJoinDto.getMuscle();
        this.weight = fatJoinDto.getWeight();
        this.body_fat = fatJoinDto.getBody_fat();
    }
}
