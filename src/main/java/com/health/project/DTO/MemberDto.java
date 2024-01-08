package com.health.project.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberDto {
    private String id;
    private String password;
    private String name;
    public MemberDto(String id, String password,String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
}
