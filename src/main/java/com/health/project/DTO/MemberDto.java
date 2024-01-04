package com.health.project.DTO;

import com.health.project.Entity.MemberRoll;
import com.health.project.Entity.Performance;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberDto {
    private String username;
    private String password;
}
