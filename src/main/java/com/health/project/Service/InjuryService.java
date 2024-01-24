package com.health.project.Service;

import com.health.project.DTO.JoinDTO.InjuryJoinDto;
import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Workout.Injury;
import com.health.project.Repository.Member.MemberRepository;
import com.health.project.Repository.workOut.InjuryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InjuryService {
    private final InjuryRepository injuryRepository;
    private final MemberRepository memberRepository;
    public void join(Long no, InjuryJoinDto injuryJoinDto){
        Member member = memberRepository.findById(no).get();
        Injury injury = new Injury(injuryJoinDto.getPart(),injuryJoinDto.getInjuryName(),injuryJoinDto.getPersistent());
        injury.setMember(member);
        injuryRepository.save(injury);
    }
    //DB저장
}
