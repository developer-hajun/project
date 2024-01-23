package com.health.project.DTO.JoinDTO;

import com.health.project.Entity.Workout.BodyPart;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class InjuryJoinDto {
    @Enumerated(EnumType.STRING)
    private BodyPart part;
    private String injuryName;
    private int persistent;

    public InjuryJoinDto(BodyPart part, String injuryName, int persistent) {
        this.part = part;
        this.injuryName = injuryName;
        this.persistent = persistent;
    }
}
