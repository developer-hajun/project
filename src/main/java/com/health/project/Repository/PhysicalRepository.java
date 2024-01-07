package com.health.project.Repository;

import com.health.project.Entity.Physical_test.Physical;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PhysicalRepository {
    private final EntityManager em;
    private final JPAQueryFactory query;

    public PhysicalRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }
    public void save(Physical physical){
        em.persist(physical);
    }
    public Optional<Physical> findByNo(Long no){
        return Optional.ofNullable(em.find(Physical.class, no));
    }

}
