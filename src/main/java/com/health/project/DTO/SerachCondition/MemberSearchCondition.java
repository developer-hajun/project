package com.health.project.DTO.SerachCondition;

import com.health.project.Entity.Member.MemberRoll;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MemberSearchCondition {
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MemberRoll roll;
}
