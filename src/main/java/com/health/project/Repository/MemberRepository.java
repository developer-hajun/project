package com.health.project.Repository;

import com.health.project.Entity.Body.QinBody;
import com.health.project.Entity.Dite.QManaging_diet;
import com.health.project.Entity.Member.Member;
import com.health.project.Entity.Member.QMember;
import com.health.project.Entity.Physical_test.QPhysical;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.health.project.Entity.Body.QinBody.inBody;
import static com.health.project.Entity.Dite.QManaging_diet.managing_diet;
import static com.health.project.Entity.Member.QMember.member;
import static com.health.project.Entity.Microorganism.QMicroorganism.microorganism;
import static com.health.project.Entity.Physical_test.QPhysical.physical;
import static com.health.project.Entity.Workout.QWorkOut.workOut;


@Repository
@Getter
public class MemberRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;
    public MemberRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }
    public void save(Member member){
        em.persist(member);
    }
    public List<Member> findAll(){
        return query.selectFrom(member).fetch();
    }
    public Optional<Member> findById(String id){
        return Optional.ofNullable(query.selectFrom(member).where(member.id.eq(id)).fetchOne());
    }
    public Optional<Member> findByNo(Long no){
        return Optional.ofNullable(em.find(Member.class, no));
    }

    public Optional<Member> findWithDite(String id){
        Member member = query.selectFrom(QMember.member).
                join(QMember.member.diets, managing_diet).fetchJoin().fetchOne();
        return Optional.ofNullable(member);
    }

    public Optional<Member> findWithMicroorganism(String id){
        Member member = query.selectFrom(QMember.member).
                join(QMember.member.microorganism,microorganism).fetchJoin().fetchOne();
        return Optional.ofNullable(member);
    }
    public Optional<Member> findWithPhysical(String id){
        Member member = query.selectFrom(QMember.member).
                join(QMember.member.physicalList,physical).fetchJoin().fetchOne();
        return Optional.ofNullable(member);
    }
    public Optional<Member> findWithinBody(String id){
        Member member = query.selectFrom(QMember.member).
                join(QMember.member.inBodies,inBody).fetchJoin().fetchOne();
        return Optional.ofNullable(member);
    }
    public Optional<Member> findWithWorkOut(String id){
        Member member = query.selectFrom(QMember.member).
                join(QMember.member.workOuts,workOut).fetchJoin().fetchOne();
        return Optional.ofNullable(member);
    }

}
