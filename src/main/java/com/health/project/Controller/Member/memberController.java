package com.health.project.Controller.Member;

import com.health.project.DTO.MemberDto;
import com.health.project.DTO.MemberLoginDto;
import com.health.project.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class memberController {
    private final MemberService memberService;
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberDto dto){
        memberService.join(dto.getId(), dto.getPassword(),dto.getName());
        return ResponseEntity.ok().body("SUCCESS");
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberLoginDto dto){
        String token = memberService.login(dto.getId(), dto.getPassword());
        return ResponseEntity.ok().body(token);
    }
}
