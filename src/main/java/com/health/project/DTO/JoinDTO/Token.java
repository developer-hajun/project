package com.health.project.DTO.JoinDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Token {
    private String AccessToken;
    private String ReFreshToken;
    private String key;
}
