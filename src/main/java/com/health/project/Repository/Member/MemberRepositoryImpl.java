package com.health.project.Repository.Member;

import com.health.project.DTO.SerachCondition.MemberSearchCondition;
import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Member.MemberRoll;
import com.health.project.Entity.Member.QMember;
import com.health.project.Repository.Querydsl4RepositorySupport;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.health.project.Entity.Body.QinBody.inBody;
import static com.health.project.Entity.Dite.QManaging_diet.managing_diet;
import static com.health.project.Entity.Member.QMember.member;
import static com.health.project.Entity.Microorganism.QMicroorganism.microorganism;
import static com.health.project.Entity.Workout.QWorkOut.workOut;


@Repository
@Getter
public class MemberRepositoryImpl  extends Querydsl4RepositorySupport implements MemberRepositoryCustom{
    public MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public Optional<Member> findByMemberId(String id){
        return Optional.ofNullable(selectFrom(member).where(member.id.eq(id)).fetchOne());
    }
    @Override
    public Optional<Member> findWithDite(String id){
        Member member = selectFrom(QMember.member).
                join(QMember.member.diets, managing_diet).fetchJoin().fetchOne();
        return Optional.ofNullable(member);
    }
    @Override
    public Optional<Member> findWithMicroorganism(String id){
        Member member = selectFrom(QMember.member).
                join(QMember.member.microorganism,microorganism).fetchJoin().fetchOne();
        return Optional.ofNullable(member);
    }
    @Override
    public Optional<Member> findWithinBody(String id){
        Member members = selectFrom(member).
                join(member.inBodies,inBody).fetchJoin().fetchOne();
        return Optional.ofNullable(members);
    }
    @Override
    public Optional<Member> findWithWorkOut(String id){
        Member member = selectFrom(QMember.member).
                join(QMember.member.workOuts,workOut).fetchJoin().fetchOne();
        return Optional.ofNullable(member);
    }

    @Override
    public List<Member> WhereParam(MemberSearchCondition condition) {
        return select(member)
                .from(member)
                .where(
                        IdEq(condition.getId()),
                        NameEq(condition.getName()),
                        RollEq(condition.getRoll())
                )
                .fetch();
    }

    private BooleanExpression RollEq(MemberRoll roll) {
        return roll!=null?member.roll.eq(roll):null;
    }

    private BooleanExpression NameEq(String name) {
        return name!=null ? member.name.eq(name) : null;
    }

    private BooleanExpression IdEq(String id) {
        return id!=null ? member.id.eq(id) : null;
    }
}
