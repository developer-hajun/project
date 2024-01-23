package com.health.project.DTO.JoinDTO;

import com.health.project.Entity.Workout.WorkoutType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class WorkOutJoinDto {
    @Enumerated(EnumType.STRING)
    private WorkoutType type;
    public WorkOutJoinDto(WorkoutType type) {
        this.type = type;
    }
}
