package com.health.project.Service;

import com.health.project.Entity.Body.*;
import com.health.project.Entity.Member.Member;
import com.health.project.Repository.Member.MemberRepository;
import com.health.project.Repository.inbody.InBodyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InbodyService {
    private final MemberRepository memberRepository;
    private final InBodyRepository inBodyRepository;

    @Transactional
    public void join(Long id){
        Body_balance body_balance = new Body_balance(1,2,3,4,5);
        Body_Composition bodyComposition = new Body_Composition(1,2,3,4);
        Muscle_fat muscle_fat = new Muscle_fat(1,2,3);
        Obesity_diagnosis obesity_diagnosis = new Obesity_diagnosis(1,2,3);
        inBody inBody = new inBody(bodyComposition,muscle_fat,obesity_diagnosis,body_balance);
        Member member = memberRepository.findById(id).get();
        inBody.setMember(member);
        inBodyRepository.save(inBody);
    }

    public List<inBody> findAll(Long no){
        return inBodyRepository.findByMemberNo(no);
    }

    public inBody findLastInbody(Long no){
        return inBodyRepository.findByMemberNo(no).get(0);
    }


}
