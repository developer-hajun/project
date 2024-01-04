package com.health.project.Controller.Member;

import com.health.project.Entity.LoginEntity;
import com.health.project.Entity.Member;
import com.health.project.Service.LoginService;
import com.health.project.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<String> login(){
        return ResponseEntity.ok().body("token");
    }
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody LoginEntity dto){
        return ResponseEntity.ok().body("token");
    }
}
