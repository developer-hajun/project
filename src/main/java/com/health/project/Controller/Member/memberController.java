package com.health.project.Controller.Member;

import com.health.project.DTO.MemberDto;
import com.health.project.DTO.MemberLoginDto;
import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Microorganism.Microorganism;
import com.health.project.Repository.microorganism.MicroorganismRepository;
import com.health.project.Service.MemberService;
import com.health.project.Service.MicroorganismService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class memberController {
    private final MemberService memberService;
    private final MicroorganismService microorganismService;
    private final MicroorganismRepository microorganismRepository;
    private final EntityManager entityManager;
    @Value("${jwt.token.secret}")
    private String key;
    private final Logger log = LoggerFactory.getLogger(getClass());
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
    @PostMapping("/Test")
    public List<Microorganism> test(Principal principal){
        Member hajun = memberService.findOne("hajun");
        Microorganism microorganism =  new Microorganism("a",1.1);
        microorganism.setMember(hajun);
        microorganismRepository.save(microorganism);
        List<Microorganism> microorganisms = microorganismService.MemberMicroorganism(Long.parseLong(principal.getName()));
        return microorganisms;
    }

}
