package com.health.project.Repository.microbiome;

import com.health.project.Entity.Microorganism.Microbiome;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.health.project.Entity.Microorganism.QMicrobiome.microbiome;
import static com.health.project.Entity.Microorganism.QMicroorganism.microorganism;


@Repository
@Getter
public class MicrobiomeRepositoryImpl implements MicrobiomeRepositoryCustom {

    private final JPAQueryFactory query;
    public MicrobiomeRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }
    @Override
    public Optional<Microbiome> findWithMicroorganism(Long no){
        Microbiome microbiome1 = query.selectFrom(microbiome).join(microbiome.microorganismList, microorganism).fetchJoin().fetchOne();
        return Optional.ofNullable(microbiome1);
    }

}
