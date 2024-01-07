package com.health.project.Repository;

import com.health.project.Entity.Microorganism.Microorganism;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.health.project.Entity.Member.QMember.member;
import static com.health.project.Entity.Microorganism.QMicrobiome.microbiome;
import static com.health.project.Entity.Microorganism.QMicroorganism.microorganism;

@Repository
public class microorganismRepository {
    private final EntityManager em;
    private final JPAQueryFactory query;

    public microorganismRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }
    public void save(Microorganism microorganism){
        em.persist(microorganism);
    }
    public Optional<Microorganism> findByNo(Long no) {
        return Optional.ofNullable(em.find(Microorganism.class, no));
    }
    public Optional<Microorganism> findWithMicrobiome(Long no){
        Microorganism microorganism1 = query.selectFrom(microorganism).join(microorganism.microbiome, microbiome).fetchJoin().fetchOne();
        return Optional.ofNullable(microorganism1);
    }
    public Optional<Microorganism> findWithMember(Long no){
        Microorganism microorganism1 = query.selectFrom(microorganism).join(microorganism.member, member).fetchJoin().fetchOne();
        return Optional.ofNullable(microorganism1);
    }
}

