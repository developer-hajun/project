package com.health.project.DTO.SerachCondition;

import com.health.project.Entity.Microorganism.Hazard;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MicrobiomeSearchCondition {
    private String name;

    @Enumerated(EnumType.STRING)
    private Hazard hazard;
}
