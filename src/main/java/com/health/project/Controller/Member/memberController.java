package com.health.project.Controller.Member;

import com.health.project.DTO.JoinDTO.MemberJoinDto;
import com.health.project.DTO.JoinDTO.MemberLoginDto;
import com.health.project.Entity.Body.inBody;
import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Microorganism.Microorganism;
import com.health.project.Entity.Physical_test.BasicPhysical;
import com.health.project.Entity.Physical_test.TechnologyPhysical;
import com.health.project.Repository.inbody.InBodyRepository;
import com.health.project.Repository.microorganism.MicroorganismRepository;
import com.health.project.Service.*;
import com.querydsl.core.Tuple;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final InbodyService inbodyService;

    private final AlarmService alarmService;

    private final BasicPhysicalService basicPhysicalService;

    private final TechnologyPhysicalService technologyPhysicalService;

    private final EntityManager entityManager;
    @Value("${jwt.token.secret}")
    private String key;

    private final Logger log = LoggerFactory.getLogger(getClass());
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberJoinDto dto){
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
    @GetMapping("/DashBord")
    public void dashbord(Principal principal, Model model){
        Long Member_no = Long.parseLong(principal.getName());
        inBody lastInbody = inbodyService.findLastInbody(Member_no);
        BasicPhysical basicPhysical = basicPhysicalService.MemberLastPhysical(Member_no);
        TechnologyPhysical technologyPhysical = technologyPhysicalService.MemberLastPhysical(Member_no);
        Boolean AlarmView = alarmService.notViewAlarm(Member_no);
        model.addAttribute("Inbody",lastInbody);
        model.addAttribute("basicPhysical",basicPhysical);
        model.addAttribute("technologyPhysical",technologyPhysical);
        model.addAttribute("AlarmView",AlarmView);
    }
    @GetMapping("/Inbody")
    public void inbody(Principal principal,Model model){
        Long Member_no = Long.parseLong(principal.getName());
        List<inBody> all = inbodyService.findAll(Member_no);
        model.addAttribute("inbody",all);
    }
    @GetMapping("physical")
    public void physical(Principal principal,Model model){
        Long Member_no = Long.parseLong(principal.getName());
        List<TechnologyPhysical> technologyPhysicals = technologyPhysicalService.MemberPhysical(Member_no);
        Tuple tuple = technologyPhysicalService.allAvg();
    }
}
