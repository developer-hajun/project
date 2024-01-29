package com.health.project.Service;

import com.health.project.DTO.JoinDTO.AlarmJoinDto;
import com.health.project.Entity.Alarm.Alarm;
import com.health.project.Entity.Member.Member;
import com.health.project.Repository.AlarmRepository;
import com.health.project.Repository.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AlarmService {
    private final AlarmRepository alarmRepository;
    private final MemberRepository memberRepository;
    public void join(Long no, AlarmJoinDto JoinDto){
        Member member = memberRepository.findById(no).get();
        Alarm alarm = new Alarm(JoinDto.getDetail());
        alarm.setMember(member);
        alarmRepository.save(alarm);
    }
    //DB저장
    public List<Alarm> findAlarm(Long no){
        return alarmRepository.findByMember_no(no);
    }
    public Boolean notViewAlarm(Long no){
        return alarmRepository.findNotview(no);
    }

}
