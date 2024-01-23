package com.health.project.Service;

import com.health.project.DTO.JoinDTO.FatigueJoinDto;
import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Workout.Fatigue;
import com.health.project.Repository.Member.MemberRepository;
import com.health.project.Repository.workOut.FatigueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FatigueService {
    private final FatigueRepository fatigueRepository;
    private final MemberRepository memberRepository;
    public void join(Long no, FatigueJoinDto fatigueJoinDto){
        Member member = memberRepository.findById(no).get();
        Fatigue fatigue = new Fatigue(fatigueJoinDto.getBodyPart(),fatigueJoinDto.getPersent());
        fatigue.setMember(member);
        fatigueRepository.save(fatigue);
    }

}
