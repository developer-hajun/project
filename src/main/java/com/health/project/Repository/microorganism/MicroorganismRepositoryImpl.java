package com.health.project.Repository.microorganism;

import com.health.project.Entity.Microorganism.Microbiome;
import com.health.project.Entity.Microorganism.Microorganism;
import com.health.project.Repository.microbiome.MicrobiomeRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.health.project.Entity.Member.QMember.member;
import static com.health.project.Entity.Microorganism.QMicrobiome.microbiome;
import static com.health.project.Entity.Microorganism.QMicroorganism.microorganism;


@Repository
@Getter
public class MicroorganismRepositoryImpl implements MicroorganismRepositoryCustom {

    private final JPAQueryFactory query;
    public MicroorganismRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Optional<Microorganism> findWithMicrobiome(Long no) {
        Microorganism microorganism1 = query.selectFrom(microorganism).join(microorganism.microbiome, microbiome).fetchJoin().fetchOne();
        return Optional.ofNullable(microorganism1);
    }

    @Override
    public Optional<Microorganism> findWithMember(Long no) {
        Microorganism microorganism1 = query.selectFrom(microorganism).join(microorganism.member, member).fetchJoin().fetchOne();
        return Optional.ofNullable(microorganism1);
    }
}
