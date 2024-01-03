package com.health.project.Repository;

import com.health.project.Entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.health.project.Entity.QMember.member;


@Repository
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
}
