package com.health.project.Repository.Member;


import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Microorganism.Microorganism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long>,MemberRepositoryCustom {
}
