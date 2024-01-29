package com.health.project.Service;

import com.health.project.DTO.JoinDTO.BasicPhysicalJoinDTO;
import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Physical_test.BasicPhysical;
import com.health.project.Repository.Member.MemberRepository;
import com.health.project.Repository.physical.BasicPhysicalRepository;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BasicPhysicalService {
    private final BasicPhysicalRepository basicPhysicalRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public void join(Long no, BasicPhysicalJoinDTO basicPhysicalJoinDTO){
        BasicPhysical physical = new BasicPhysical(
                basicPhysicalJoinDTO.getGrap(),
                basicPhysicalJoinDTO.getBack(),
                basicPhysicalJoinDTO.getRight_flat_60(),
                basicPhysicalJoinDTO.getLeft_flat_60(),
                basicPhysicalJoinDTO.getRight_thigh_60(),
                basicPhysicalJoinDTO.getLeft_thigh_60(),
                basicPhysicalJoinDTO.getSit_up(),
                basicPhysicalJoinDTO.getPush_up(),
                basicPhysicalJoinDTO.getRight_flat_240(),
                basicPhysicalJoinDTO.getLeft_flat_240(),
                basicPhysicalJoinDTO.getRight_thigh_240(),
                basicPhysicalJoinDTO.getLeft_thigh_240(),
                basicPhysicalJoinDTO.getBack_bending(),
                basicPhysicalJoinDTO.getForward_bend());
        Member member = memberRepository.findById(no).get();
        physical.setMember(member);
    }
    //DB저장
    public List<BasicPhysical> MemberPhysical(String id){
        Long no = memberRepository.findByMemberId(id).get().getNo();
        return basicPhysicalRepository.findByMemberNo(no);
        //List안에 들어갈 객체를 DTO로 변환해서 반환
    }
    //사용자의 모든 기초체력 데이터 뽑아옴
    public void allAvg(Long no){
        Tuple allAvg = basicPhysicalRepository.findAllAvg();
        //DTO로 변환해서 가져가기
    }
    //전체 기초체력 평균 반환
    public BasicPhysical MemberLastPhysical(Long no){
        BasicPhysical basicPhysical = basicPhysicalRepository.findLastPhysical(no).get();
        return basicPhysical;
        //DTO로 변환해서 가져가기
    }
    //사용자의 마지막 기초체력 데이터만 가져옴



}
