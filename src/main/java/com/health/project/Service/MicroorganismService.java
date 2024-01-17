package com.health.project.Service;

import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Microorganism.Microorganism;
import com.health.project.Exception.AppException;
import com.health.project.Exception.ErrorCode;
import com.health.project.Repository.Member.MemberRepository;
import com.health.project.Repository.microorganism.MicroorganismRepository;
import com.health.project.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MicroorganismService {
    private final MicroorganismRepository microorganismRepository;
    private final MemberRepository memberRepository;
    @Value("${jwt.token.secret}")
    private String key;
    @Transactional
    public void join(String id,String name, double shame){
        microorganismRepository.findByName(name).ifPresent(
                microorganism -> {
                    throw new AppException(ErrorCode.ID_DUPLICATED,name +"는 이미 있습니다.");
                }
        );
        Member member = memberRepository.findByMemberId(id).get();
        Microorganism microorganism = new Microorganism(name,shame);
        microorganism.setMember(member);
    }

    public List<Microorganism> MemberMicroorganism(String Id){
        Long Member_No = memberRepository.findByMemberId(Id).get().getNo();
        return microorganismRepository.findByMemberNo(Member_No);
    }

}
