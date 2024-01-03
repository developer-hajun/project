package com.health.project.Repository;

import com.health.project.Entity.Microorganism;
import com.health.project.Entity.inBody;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    public Optional<Microorganism> findByNo(Long no){
        return Optional.ofNullable(em.find(Microorganism.class, no));
    }
}

