package com.health.project.Service;

import com.health.project.DTO.JoinDTO.TechnologyPhysicalJoinDTO;
import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Physical_test.TechnologyPhysical;
import com.health.project.Repository.Member.MemberRepository;
import com.health.project.Repository.physical.TechnologyPhysicalRepository;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TechnologyPhysicalService {
    private final TechnologyPhysicalRepository technologyPhysicalRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public void join(Long no, TechnologyPhysicalJoinDTO technologyPhysicalDTO){
        TechnologyPhysical technologyPhysical = new TechnologyPhysical(
                technologyPhysicalDTO.getPower(),
                technologyPhysicalDTO.getPowerMax(),
                technologyPhysicalDTO.getPowerKg(),
                technologyPhysicalDTO.getSideStep(),
                technologyPhysicalDTO.getClose_eye_right(),
                technologyPhysicalDTO.getClose_eye_left(),
                technologyPhysicalDTO.getLight_reaction(),
                technologyPhysicalDTO.getBlaze_pot()
        );
        Member member = memberRepository.findById(no).get();
        technologyPhysical.setMember(member);
        technologyPhysicalRepository.save(technologyPhysical);
    }
    //DB저장
    public List<TechnologyPhysical> MemberPhysical(String id){
        Long no = memberRepository.findByMemberId(id).get().getNo();
        return technologyPhysicalRepository.findByMemberNo(no);
        //List안에 들어갈 객체를 DTO로 변환해서 반환
    }
    //사용자의 모든 기술체력 데이터를 가져옴
    public void allAvg(Long no){
        Tuple allAvg = technologyPhysicalRepository.findAllAvg();
        //DTO로 변환해서 가져가기
    }
    //모든 사용자의 기술체력 평균을 가져옴
    public void MemberLastPhysical(Long no){
        TechnologyPhysical technologyPhysical = technologyPhysicalRepository.findLastPhysical(no).get();
//        //DTO로 변환해서 가져가기
    }
    //사용자의 마지막 기술체력을 가져옴

}
