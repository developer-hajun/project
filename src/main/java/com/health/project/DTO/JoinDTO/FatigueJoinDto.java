package com.health.project.DTO.JoinDTO;

import com.health.project.Entity.Workout.BodyPart;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class FatigueJoinDto {
    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart;
    private int persent;
    public FatigueJoinDto(BodyPart bodyPart, int persent) {
        this.bodyPart = bodyPart;
        this.persent = persent;
    }
}
