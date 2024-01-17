package com.health.project.Repository.microbiome;

import com.health.project.DTO.SerachCondition.MemberSearchCondition;
import com.health.project.DTO.SerachCondition.MicrobiomeSearchCondition;
import com.health.project.Entity.Microorganism.Hazard;
import com.health.project.Entity.Microorganism.Microbiome;
import com.health.project.Repository.Querydsl4RepositorySupport;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.health.project.Entity.Microorganism.QMicrobiome.microbiome;
import static com.health.project.Entity.Microorganism.QMicroorganism.microorganism;


@Repository
@Getter
public class MicrobiomeRepositoryImpl extends Querydsl4RepositorySupport implements MicrobiomeRepositoryCustom {

    public MicrobiomeRepositoryImpl() {
        super(Microbiome.class);
    }

    @Override
    public Optional<Microbiome> findWithMicroorganism(Long no){
        Microbiome microbiome1 = selectFrom(microbiome).join(microbiome.microorganismList, microorganism).fetchJoin().fetchOne();
        return Optional.ofNullable(microbiome1);
    }
    public List<Microbiome> WhereParam(MicrobiomeSearchCondition condition){
        return select(microbiome)
                .from(microbiome)
                .where(
                        nameEq(condition.getName()),
                        hazardEq(condition.getHazard())
                )
                .fetch();
    }

    private BooleanExpression nameEq(String name) {
        return name!=null? microbiome.name.eq(name) : null;
    }

    private BooleanExpression hazardEq(Hazard hazard) {
        return hazard!=null?microbiome.hazard.eq(hazard) : null;
    }

}
