package com.health.project.DTO.SerachCondition;

import com.health.project.Entity.Member.MemberRoll;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberSearchCondition {
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MemberRoll roll;
}
