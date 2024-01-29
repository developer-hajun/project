package com.health.project.Service;

import com.health.project.DTO.SerachCondition.MemberSearchCondition;
import com.health.project.Entity.Alarm.Alarm;
import com.health.project.Entity.Member.Member;
import com.health.project.Exception.AppException;
import com.health.project.Exception.ErrorCode;
import com.health.project.Repository.AlarmRepository;
import com.health.project.Repository.Member.MemberRepository;
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
    private final AlarmRepository alarmRepository;
    private final BCryptPasswordEncoder encoder;
    @Value("${jwt.token.secret}")
    private String key;
    private Long expireTimeMs = 1000*60*60L;

    //사용자용
    @Transactional
    public void join(String id, String password, String name){
        memberRepository.findByMemberId(id).ifPresent(member -> {
            throw new AppException(ErrorCode.ID_DUPLICATED,id +"는 이미 있습니다.");
        });
        Alarm alarm = new Alarm("D-FET에 오신걸 환영합니다");
        String EncodePassword = encoder.encode(password);
        Member member = new Member(id,EncodePassword,name);
        memberRepository.save(member);
        alarm.setMember(member);
        alarmRepository.save(alarm);
    }
    //DB저장 + 비밀번호 암호화
    public String login(String id,String password){
        Member member = memberRepository.findByMemberId(id).orElseThrow(() -> new AppException(ErrorCode.ID_NOT_FOUND, "존재하지 않는 id입니다."));
        if(!encoder.matches(password,member.getPassword())){ //matchs왼쪽이 암호화 안된것 , 오른쪽이 암호화 된것
            throw new AppException(ErrorCode.INVALID_PASSWORD, member.getPassword()+"비밀번호가 틀렷습니다");
        }
        String token = JwtTokenUtil.createToken(member.getNo(),key,expireTimeMs);
        return token;
    }
    //로그인 + 토큰발급
    public List<Member> findAllMember(){
        return memberRepository.findAll();
    }
    //모든 시용자 정보 받아오기
    public Member findOne(String id){
        return memberRepository.findByMemberId(id).get();
    }
    //특정 ID를 가진 사용자의 정보 가져오기
    
    //관리자용
    public List<Member> findParam(MemberSearchCondition condition){
       return memberRepository.WhereParam(condition);
    }
    //조건 통해서 사용자 정보가져오기
}
