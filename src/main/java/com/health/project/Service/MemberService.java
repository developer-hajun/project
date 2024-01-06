package com.health.project.Service;

import com.health.project.Entity.Member;
import com.health.project.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAllMember(){
        return memberRepository.findAll();
    }

    public Member findOne(String id){
        return memberRepository.findById(id).get();
    }

}
