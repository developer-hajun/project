package com.health.project.Login;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
//    @PostMapping("/join")
//    public ResponseEntity<String> join(@RequestBody UserJoinRequest dto){
//        userService.join(dto.getUsername(), dto.getPassword());
//        return ResponseEntity.ok().body("SUCCESS");
//    }
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody UserLoginRequest dto){
//        String token = userService.login(dto.getUsername(), dto.getPassword());
//        return ResponseEntity.ok().body(token);
//    }
}
