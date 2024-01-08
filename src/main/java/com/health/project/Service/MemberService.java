package com.health.project.Service;

import com.health.project.Entity.Member.Member;
import com.health.project.Exception.AppException;
import com.health.project.Exception.ErrorCode;
import com.health.project.Repository.Member.MemberRepository;
import com.health.project.Repository.Member.MemberRepositoryImpl;
import com.health.project.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${jwt.token.secret}")
    private String key;
    private Long expireTimeMs = 1000*60*60L;
    public void join(String id, String password, String name){
        memberRepository.findByMemberId(id).ifPresent(member -> {
            throw new AppException(ErrorCode.ID_DUPLICATED,id +"는 이미 있습니다.");
        });
        String EncodePassword = encoder.encode(password);
        Member member = new Member(id,EncodePassword,name);
        memberRepository.save(member);
    }
    public String login(String id,String password){
        Member member = memberRepository.findByMemberId(id).orElseThrow(() -> new AppException(ErrorCode.ID_NOT_FOUND, "존재하지 않는 id입니다."));
        if(!encoder.matches(password,member.getPassword())){ //matchs왼쪽이 암호화 안된것 , 오른쪽이 암호화 된것
            throw new AppException(ErrorCode.INVALID_PASSWORD, member.getPassword()+"비밀번호가 틀렷습니다");
        }
        String token = JwtTokenUtil.createToken(member.getId(),key,expireTimeMs);
        return token;
    }
    public List<Member> findAllMember(){
        return memberRepository.findAll();
    }

    public Member findOne(String id){
        return memberRepository.findByMemberId(id).get();
    }

}
