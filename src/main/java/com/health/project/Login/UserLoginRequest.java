package com.health.project.Login;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserLoginRequest {
    private String username;
    private String password;
}
