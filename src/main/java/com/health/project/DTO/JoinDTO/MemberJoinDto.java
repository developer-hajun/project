package com.health.project.DTO.JoinDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberJoinDto {
    private String id;
    private String password;
    private String name;
    public MemberJoinDto(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
}
