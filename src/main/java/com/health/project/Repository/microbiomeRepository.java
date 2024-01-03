package com.health.project.Repository;

import com.health.project.Entity.Microbiome;
import com.health.project.Entity.Microorganism;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class microbiomeRepository {
    private final EntityManager em;
    private final JPAQueryFactory query;

    public microbiomeRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }
    public void save(Microbiome microbiome){
        em.persist(microbiome);
    }
    public Optional<Microbiome> findByNo(Long no){
        return Optional.ofNullable(em.find(Microbiome.class, no));
    }
}