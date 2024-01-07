package com.health.project.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberLoginDto {
    private String id;
    private String password;
    public MemberLoginDto(String id, String password ) {
        this.id = id;
        this.password = password;
    }
}
