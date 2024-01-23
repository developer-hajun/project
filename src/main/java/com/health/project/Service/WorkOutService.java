package com.health.project.Service;

import com.health.project.DTO.JoinDTO.WorkOutJoinDto;
import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Workout.WorkOut;
import com.health.project.Repository.Member.MemberRepository;
import com.health.project.Repository.workOut.WorkOutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WorkOutService {
    private final WorkOutRepository workOutRepository;
    private final MemberRepository memberRepository;
    public void join(Long no, WorkOutJoinDto work){
        Member member = memberRepository.findById(no).get();
        WorkOut workOut = new WorkOut(work.getType());
        workOut.setMember(member);
        workOutRepository.save(workOut);
    }
}
