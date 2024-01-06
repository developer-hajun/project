package com.health.project.Service;

import com.health.project.Entity.Member;
import com.health.project.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;

    public void join(String id, String password, String name){
        String EncodePassword = encoder.encode(password);
        Member member = new Member(id,EncodePassword,name);
        memberRepository.save(member);
    }
    public List<Member> findAllMember(){
        return memberRepository.findAll();
    }

    public Member findOne(String id){
        return memberRepository.findById(id).get();
    }

}
