package com.health.project.Repository;

import com.health.project.Entity.Member;
import com.health.project.Entity.inBody;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.health.project.Entity.QMember.member;

@Repository
public class inbodyRepository {
    private final EntityManager em;
    private final JPAQueryFactory query;

    public inbodyRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }
    public void save(inBody inBody){
        em.persist(inBody);
    }
    public Optional<inBody> findByNo(Long no){
        return Optional.ofNullable(em.find(inBody.class, no));
    }
}