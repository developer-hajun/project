package com.health.project.Service;

import com.health.project.Entity.Physical_test.Physical;
import com.health.project.Repository.Member.MemberRepository;
import com.health.project.Repository.physical.PhysicalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PhysicalService {
    private final PhysicalRepository physicalRepository;
    private final MemberRepository memberRepository;
    public List<Physical> MemberPhysical(String id){
        Long no = memberRepository.findByMemberId(id).get().getNo();
        return physicalRepository.findByMemberNo(no);
    }


}
