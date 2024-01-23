package com.health.project.Service;

import com.health.project.DTO.JoinDTO.Inbody.Body_Composition_Join_Dto;
import com.health.project.DTO.JoinDTO.Inbody.Body_balance_Join_Dto;
import com.health.project.DTO.JoinDTO.Inbody.Muscle_fat_Join_Dto;
import com.health.project.DTO.JoinDTO.Inbody.Obesity_diagnosis_Join_Dto;
import com.health.project.Entity.Body.*;
import com.health.project.Entity.Member.Member;
import com.health.project.Repository.Member.MemberRepository;
import com.health.project.Repository.inbody.InBodyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InbodyService {
    private final MemberRepository memberRepository;
    private final InBodyRepository inBodyRepository;

    @Transactional
    public void join(Long id, Body_balance_Join_Dto balanceJoinDto, Body_Composition_Join_Dto CompositionJoinDto,
                     Muscle_fat_Join_Dto fatJoinDto, Obesity_diagnosis_Join_Dto diagnosisJoinDto)
    {
        Body_balance body_balance = new Body_balance(balanceJoinDto);
        Body_Composition bodyComposition = new Body_Composition(CompositionJoinDto);
        Muscle_fat muscle_fat = new Muscle_fat(fatJoinDto);
        Obesity_diagnosis obesity_diagnosis = new Obesity_diagnosis(diagnosisJoinDto);
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
