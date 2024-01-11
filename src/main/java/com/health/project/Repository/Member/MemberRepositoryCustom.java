package com.health.project.Repository.Member;

import com.health.project.DTO.SerachCondition.MemberSearchCondition;
import com.health.project.Entity.Member.Member;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.List;
import java.util.Optional;

public interface MemberRepositoryCustom {
    public Optional<Member> findByMemberId(String id);
    public Optional<Member> findWithDite(String id);
    public Optional<Member> findWithMicroorganism(String id);
    public Optional<Member> findWithPhysical(String id);
    public Optional<Member> findWithinBody(String id);
    public Optional<Member> findWithWorkOut(String id);
    public List<Member> WhereParam(@NotNull MemberSearchCondition condition);

}
