package com.health.project.Controller.Member;

import com.health.project.DTO.MemberDto;
import com.health.project.Login.UserJoinRequest;
import com.health.project.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class memberController {
//    private final MemberService memberService;
//    @PostMapping("/join")
//    public ResponseEntity<String> join(@RequestBody MemberDto dto){
//        memberService.join(dto.getId(),dto.getPassword(),dto.getName());
//        return ResponseEntity.ok().body("SUCCESS");
//    }
}