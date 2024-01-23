package com.health.project.Service;

import com.health.project.Entity.Dite.Managing_diet;
import com.health.project.Entity.Member.Member;
import com.health.project.Repository.Dite.DiteRepository;
import com.health.project.Repository.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DiteService {
    private final DiteRepository diteRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public void join(Long id){
        Member member = memberRepository.findById(id).get();
        List<String> foodName = new ArrayList<>();
        //프론트에서 어떻게 값 가져오는지에ㅔ 따라 달라짐
        Managing_diet diet = new Managing_diet(foodName);
        diet.setMember(member);
    }
    public List<List<String>> Last3Food(Long no) {
        return diteRepository.findLast3Dite(no);
    }

    public List<Managing_diet> findAllDite(Long no){
        return diteRepository.findByMemberNo(no);
    }
}
